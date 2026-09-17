package com.layered.backend.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BeautyProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String skinType;

    @ElementCollection
    private List<String> concerns = new ArrayList<>();

    @ElementCollection
    private List<String> avoidIngredients = new ArrayList<>();

    @ElementCollection
    private List<String> currentActives = new ArrayList<>();

    @ElementCollection
    private List<String> preferredScentFamilies = new ArrayList<>();

    private String occasion;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}