package com.layered.backend.dto;

import java.util.List;

public class AiCreateJobRequest {

    private String profileId;
    private String track;
    private String skinType;
    private String category;
    private List<String> concerns;
    private List<String> avoidIngredients;
    private List<String> currentActives;
    private List<String> preferredScentFamilies;
    private String occasion;

    public String getProfileId() { return profileId; }
    public void setProfileId(String profileId) { this.profileId = profileId; }

    public String getTrack() { return track; }
    public void setTrack(String track) { this.track = track; }

    public String getSkinType() { return skinType; }
    public void setSkinType(String skinType) { this.skinType = skinType; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public List<String> getConcerns() { return concerns; }
    public void setConcerns(List<String> concerns) { this.concerns = concerns; }

    public List<String> getAvoidIngredients() { return avoidIngredients; }
    public void setAvoidIngredients(List<String> avoidIngredients) { this.avoidIngredients = avoidIngredients; }

    public List<String> getCurrentActives() { return currentActives; }
    public void setCurrentActives(List<String> currentActives) { this.currentActives = currentActives; }

    public List<String> getPreferredScentFamilies() { return preferredScentFamilies; }
    public void setPreferredScentFamilies(List<String> preferredScentFamilies) { this.preferredScentFamilies = preferredScentFamilies; }

    public String getOccasion() { return occasion; }
    public void setOccasion(String occasion) { this.occasion = occasion; }
}