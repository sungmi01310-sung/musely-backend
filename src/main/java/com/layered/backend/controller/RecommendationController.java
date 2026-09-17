package com.layered.backend.controller;

import com.layered.backend.client.AiCoreClient;
import com.layered.backend.domain.BeautyProfile;
import com.layered.backend.domain.JobStatus;
import com.layered.backend.domain.Recommendation;
import com.layered.backend.domain.RecommendationJob;
import com.layered.backend.dto.*;
import com.layered.backend.repository.BeautyProfileRepository;
import com.layered.backend.repository.RecommendationJobRepository;
import com.layered.backend.repository.RecommendationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationJobRepository recommendationJobRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @Autowired
    private BeautyProfileRepository beautyProfileRepository;

    @Autowired
    private AiCoreClient aiCoreClient;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping
    public ResponseEntity<JobResponse> requestRecommendation(@RequestBody RecommendationRequest request) {

        BeautyProfile profile = beautyProfileRepository.findById(request.getProfileId()).orElse(null);
        if (profile == null) {
            return ResponseEntity.badRequest().build();
        }

        AiCreateJobRequest aiRequest = new AiCreateJobRequest();
        aiRequest.setProfileId(String.valueOf(profile.getId()));
        aiRequest.setTrack(request.getTrack());
        aiRequest.setSkinType(profile.getSkinType());
        aiRequest.setConcerns(profile.getConcerns());
        aiRequest.setAvoidIngredients(profile.getAvoidIngredients());
        aiRequest.setCurrentActives(profile.getCurrentActives());
        aiRequest.setPreferredScentFamilies(profile.getPreferredScentFamilies());
        aiRequest.setOccasion(profile.getOccasion());

        AiCreateJobResponse aiResponse = aiCoreClient.createJob(aiRequest);

        RecommendationJob job = new RecommendationJob();
        job.setUserId(request.getUserId());
        job.setProfileId(request.getProfileId());
        job.setTrack(request.getTrack());
        job.setStatus(JobStatus.PENDING);
        job.setAiJobId(aiResponse.getJobId());

        RecommendationJob savedJob = recommendationJobRepository.save(job);

        JobResponse response = new JobResponse(savedJob.getId(), savedJob.getStatus().toString());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<RecommendationJob> getJobStatus(@PathVariable Long jobId) {

        RecommendationJob job = recommendationJobRepository.findById(jobId).orElse(null);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }

        if (job.getStatus() == JobStatus.PENDING || job.getStatus() == JobStatus.RUNNING) {

            AiJobStatusResponse aiStatus = aiCoreClient.getJobStatus(job.getAiJobId());

            if ("DONE".equals(aiStatus.getStatus())) {
                Recommendation recommendation = new Recommendation();
                recommendation.setJobId(job.getId());
                recommendation.setUserId(job.getUserId());
                recommendation.setTrack(job.getTrack());
                recommendation.setSummary(aiStatus.getResult().getSummary());
                recommendation.setRelaxationLevel(aiStatus.getResult().getRelaxationLevel());
                recommendation.setItemsJson(toJson(aiStatus.getResult()));
                recommendation.setCautionsJson(toJson(aiStatus.getResult().getCautions()));

                Recommendation savedRecommendation = recommendationRepository.save(recommendation);

                job.setStatus(JobStatus.DONE);
                job.setRecommendationId(savedRecommendation.getId());
                job.setFinishedAt(LocalDateTime.now());
                recommendationJobRepository.save(job);

            } else if ("FAILED".equals(aiStatus.getStatus())) {
                job.setStatus(JobStatus.FAILED);
                job.setFinishedAt(LocalDateTime.now());
                if (aiStatus.getError() != null) {
                    job.setErrorMessage(aiStatus.getError().getCode() + ": " + aiStatus.getError().getMessage());
                }
                recommendationJobRepository.save(job);
            }
            // RUNNING/PENDING이면 지금 상태 그대로 돌려줌 (다음 폴링 때 다시 물어봄)
        }

        return ResponseEntity.ok(job);
    }

    @PostMapping("/jobs/{jobId}/complete")
    public ResponseEntity<RecommendationJob> completeJob(@PathVariable Long jobId, @RequestBody CompleteJobRequest request) {

        RecommendationJob job = recommendationJobRepository.findById(jobId).orElse(null);
        if (job == null) {
            return ResponseEntity.notFound().build();
        }

        Recommendation recommendation = new Recommendation();
        recommendation.setJobId(job.getId());
        recommendation.setUserId(job.getUserId());
        recommendation.setTrack(job.getTrack());
        recommendation.setSummary(request.getSummary());
        recommendation.setItemsJson(request.getItemsJson());
        recommendation.setCautionsJson(request.getCautionsJson());

        Recommendation savedRecommendation = recommendationRepository.save(recommendation);

        job.setStatus(JobStatus.DONE);
        job.setRecommendationId(savedRecommendation.getId());
        job.setFinishedAt(LocalDateTime.now());
        recommendationJobRepository.save(job);

        return ResponseEntity.ok(job);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recommendation> getRecommendation(@PathVariable Long id) {
        return recommendationRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/history/{userId}")
    public java.util.List<Recommendation> getHistory(@PathVariable Long userId) {
        return recommendationRepository.findByUserId(userId);
    }

    private String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            return "[]";
        }
    }
}