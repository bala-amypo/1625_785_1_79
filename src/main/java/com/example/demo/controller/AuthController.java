package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService us, JwtUtil jwt) {
        this.userService = us;
        this.jwtUtil = jwt;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserEntity user) {
        UserEntity saved = userService.register(user);
        return jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
    }
}
