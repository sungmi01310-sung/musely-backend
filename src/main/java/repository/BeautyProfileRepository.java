package com.layered.backend.repository;

import com.layered.backend.domain.BeautyProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeautyProfileRepository extends JpaRepository<BeautyProfile, Long> {
}