package com.layered.backend.service;

import com.layered.backend.domain.User;
import com.layered.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // DB에 있으면 그 사용자를, 없으면 새로 만들어서 돌려줌
    @Transactional
    public User getOrCreate(String firebaseUid, String email) {
        return userRepository.findByFirebaseUid(firebaseUid)
                .orElseGet(() -> userRepository.save(new User(firebaseUid, email)));
    }
}