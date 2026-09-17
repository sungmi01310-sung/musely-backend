package com.layered.backend.repository;

import com.layered.backend.domain.RecommendationJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationJobRepository extends JpaRepository<RecommendationJob, Long> {
}