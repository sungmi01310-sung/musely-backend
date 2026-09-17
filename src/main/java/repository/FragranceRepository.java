package com.layered.backend.repository;

import com.layered.backend.domain.Fragrance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FragranceRepository extends JpaRepository<Fragrance, Long> {
}