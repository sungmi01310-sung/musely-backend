package com.layered.backend.controller;

import com.layered.backend.domain.JobStatus;
import com.layered.backend.domain.Recommendation;
import com.layered.backend.domain.RecommendationJob;
import com.layered.backend.dto.CompleteJobRequest;
import com.layered.backend.dto.JobResponse;
import com.layered.backend.dto.RecommendationRequest;
import com.layered.backend.repository.RecommendationJobRepository;
import com.layered.backend.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationJobRepository recommendationJobRepository;

    @Autowired
    private RecommendationRepository recommendationRepository;

    @PostMapping
    public ResponseEntity<JobResponse> requestRecommendation(@RequestBody RecommendationRequest request) {

        RecommendationJob job = new RecommendationJob();
        job.setUserId(request.getUserId());
        job.setProfileId(request.getProfileId());
        job.setTrack(request.getTrack());
        job.setStatus(JobStatus.PENDING);

        RecommendationJob savedJob = recommendationJobRepository.save(job);

        JobResponse response = new JobResponse(savedJob.getId(), savedJob.getStatus().toString());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<RecommendationJob> getJobStatus(@PathVariable Long jobId) {
        return recommendationJobRepository.findById(jobId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
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
        job.setFinishedAt(java.time.LocalDateTime.now());
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
}