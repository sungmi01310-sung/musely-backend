package com.layered.backend.dto;

public class FeedbackRequest {

    private Long recommendationId;
    private Integer rating;
    private String comment;

    public Long getRecommendationId() { return recommendationId; }
    public void setRecommendationId(Long recommendationId) { this.recommendationId = recommendationId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}