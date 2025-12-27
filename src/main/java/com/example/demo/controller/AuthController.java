// package com.example.demo.controller;

// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;

//     public AuthController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.register(user);
//     }

//     @GetMapping("/email/{email}")
//     public User findByEmail(@PathVariable String email) {
//         return userService.findByEmail(email);
//     }
// }
package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Security.JwtUtil;
import com.example.springboot.dto.AuthRequest;
import com.example.springboot.dto.AuthResponse;
import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
   @Autowired
    UserService ser;
    @Autowired
    PasswordEncoder encoder;


    @Autowired JwtUtil util;

    @PostMapping("/add")
    public User addExtraStudent(@RequestBody ExtraStudent stu) {
        return ser.saveExtraStudent(stu);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        ExtraStudent student = ser.CheckEmail(request.getEmail());
        if (student == null) {
            throw new RuntimeException("User Not Found");

        }
        if (!encoder.matches(request.getPassword(), student.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // return "Login successful for " + student.getEmail();


        String token = util.generateToken(
                student.getEmail(),
                student.getRole()
        );


        return new AuthResponse(token, student.getRole());

    }
}

