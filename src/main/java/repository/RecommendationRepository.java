package com.layered.backend.repository;

import com.layered.backend.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findByUserId(Long userId);

}