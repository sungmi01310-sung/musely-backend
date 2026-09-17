package com.layered.backend.controller;

import com.layered.backend.domain.Feedback;
import com.layered.backend.dto.FeedbackRequest;
import com.layered.backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @PostMapping
    public Feedback createFeedback(@RequestBody FeedbackRequest request) {
        Feedback feedback = new Feedback();
        feedback.setRecommendationId(request.getRecommendationId());
        feedback.setRating(request.getRating());
        feedback.setComment(request.getComment());
        return feedbackRepository.save(feedback);
    }
}