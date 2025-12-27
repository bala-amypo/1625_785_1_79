package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Role;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    // private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repo) {
        this.userRepository = repo;
        // this.passwordEncoder = encoder;
    }

    @Override
    public User register(User user) {

        if (user.getEmail() == null || user.getEmail().isBlank())
            throw new IllegalArgumentException("Email cannot be empty");

        if (user.getPassword() == null || user.getPassword().isBlank())
            throw new IllegalArgumentException("Password cannot be empty");

   
        // user.setPassword(passwordEncoder.encode(user.getPassword()));

       if (user.getRole() == null) {
    user.setRole(Role.USER);
}

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
