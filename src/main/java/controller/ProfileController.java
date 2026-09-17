package com.layered.backend.controller;

import com.layered.backend.domain.BeautyProfile;
import com.layered.backend.dto.BeautyProfileRequest;
import com.layered.backend.repository.BeautyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private BeautyProfileRepository beautyProfileRepository;

    @PostMapping
    public BeautyProfile createProfile(@RequestBody BeautyProfileRequest request) {
        BeautyProfile profile = new BeautyProfile();
        profile.setUserId(request.getUserId());
        profile.setSkinType(request.getSkinType());
        profile.setConcerns(request.getConcerns());
        profile.setAvoidIngredients(request.getAvoidIngredients());
        profile.setCurrentActives(request.getCurrentActives());
        profile.setPreferredScentFamilies(request.getPreferredScentFamilies());
        profile.setOccasion(request.getOccasion());
        return beautyProfileRepository.save(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeautyProfile> getProfile(@PathVariable Long id) {
        return beautyProfileRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}