package com.layered.backend.controller;

import com.layered.backend.domain.Fragrance;
import com.layered.backend.dto.FragranceRequest;
import com.layered.backend.repository.FragranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fragrances")
public class FragranceController {

    @Autowired
    private FragranceRepository fragranceRepository;

    @PostMapping
    public Fragrance createFragrance(@RequestBody FragranceRequest request) {
        Fragrance fragrance = new Fragrance();
        fragrance.setName(request.getName());
        fragrance.setBrand(request.getBrand());
        fragrance.setNoteFamily(request.getNoteFamily());
        fragrance.setTopNotes(request.getTopNotes());
        fragrance.setHeartNotes(request.getHeartNotes());
        fragrance.setBaseNotes(request.getBaseNotes());
        fragrance.setDescription(request.getDescription());
        return fragranceRepository.save(fragrance);
    }

    @GetMapping
    public List<Fragrance> getAllFragrances() {
        return fragranceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fragrance> getFragrance(@PathVariable Long id) {
        return fragranceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}