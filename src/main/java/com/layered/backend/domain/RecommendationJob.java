package com.layered.backend.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RecommendationJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long profileId;
    private String track;

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.PENDING;

    private String aiJobId;
    private Long recommendationId;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime finishedAt;
    private String errorMessage;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }

    public String getTrack() { return track; }
    public void setTrack(String track) { this.track = track; }

    public JobStatus getStatus() { return status; }
    public void setStatus(JobStatus status) { this.status = status; }

    public String getAiJobId() { return aiJobId; }
    public void setAiJobId(String aiJobId) { this.aiJobId = aiJobId; }

    public Long getRecommendationId() { return recommendationId; }
    public void setRecommendationId(Long recommendationId) { this.recommendationId = recommendationId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getFinishedAt() { return finishedAt; }
    public void setFinishedAt(LocalDateTime finishedAt) { this.finishedAt = finishedAt; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}