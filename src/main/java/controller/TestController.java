package com.layered.backend.controller;

import com.layered.backend.domain.User;
import com.layered.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/test/user")
    public User createTestUser() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setName("테스트유저");
        return userRepository.save(user);
    }
}