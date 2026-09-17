package com.layered.backend.dto;

import java.util.List;

public class BeautyProfileRequest {

    private Long userId;
    private String skinType;
    private List<String> concerns;
    private List<String> avoidIngredients;
    private List<String> currentActives;
    private List<String> preferredScentFamilies;
    private String occasion;

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getSkinType() { return skinType; }
    public void setSkinType(String skinType) { this.skinType = skinType; }

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