package com.layered.backend.dto;

import java.util.List;

public class RecommendationRequest {

    private Long userId;
    private Long profileId;
    private String track;  // "cosmetic", "fragrance", "both"

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }

    public String getTrack() { return track; }
    public void setTrack(String track) { this.track = track; }
}