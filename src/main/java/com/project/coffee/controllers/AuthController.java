package com.project.coffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.entities.User;
import com.project.coffee.services.auth.AuthService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @PostMapping("")
    public AuthResponse create(@RequestBody AuthRequest request) {
        String token = authService.authenticate("email", "password");

        AuthResponse response = new AuthResponse();
        response.setToken(token);

        return response;
    }

    @GetMapping("/userinfo")
    public User create() {
        Boolean isTokenValid = authService.isTokenValid("token");
        if (!isTokenValid) {
            throw new Error("Token is invalid");
        }

        User user = new User();
        return user;
    }
}

class AuthRequest {
    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;
}

class AuthResponse {
    @Getter @Setter
    private String token;
}