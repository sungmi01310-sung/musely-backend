package com.layered.backend.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;
    private Long userId;
    private String track;

    @Column(columnDefinition = "TEXT")
    private String itemsJson;

    @Column(length = 2000)
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String cautionsJson;

    private Integer relaxationLevel = 0;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getTrack() { return track; }
    public void setTrack(String track) { this.track = track; }

    public String getItemsJson() { return itemsJson; }
    public void setItemsJson(String itemsJson) { this.itemsJson = itemsJson; }

    public String getSummary() { return summary; }
    public void setSummary(String summary) { this.summary = summary; }

    public String getCautionsJson() { return cautionsJson; }
    public void setCautionsJson(String cautionsJson) { this.cautionsJson = cautionsJson; }

    public Integer getRelaxationLevel() { return relaxationLevel; }
    public void setRelaxationLevel(Integer relaxationLevel) { this.relaxationLevel = relaxationLevel; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}