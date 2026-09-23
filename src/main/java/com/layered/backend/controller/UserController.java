package com.layered.backend.controller;

import com.layered.backend.dto.UserResponse;
import com.layered.backend.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 로그인한 사람의 정보 조회 (처음이면 자동 가입)
    @GetMapping("/api/me")
    public UserResponse me(@RequestAttribute("uid") String uid,
                           @RequestAttribute(value = "email", required = false) String email) {
        return UserResponse.from(userService.getOrCreate(uid, email));
    }
}