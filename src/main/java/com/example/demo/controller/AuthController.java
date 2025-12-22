package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userService.register(user);
    }

    @GetMapping("/email/{email}")
    public UserEntity findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
