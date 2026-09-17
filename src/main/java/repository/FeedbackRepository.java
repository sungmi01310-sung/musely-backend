package com.layered.backend.repository;

import com.layered.backend.domain.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}