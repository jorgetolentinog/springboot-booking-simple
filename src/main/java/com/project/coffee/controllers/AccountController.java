package com.project.coffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.entities.User;
import com.project.coffee.payload.LoginRequest;
import com.project.coffee.payload.LoginResponse;
import com.project.coffee.services.auth.AuthService;
import com.project.coffee.services.user.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String token = authService.authenticate("email", "password");

        LoginResponse response = new LoginResponse();
        response.setToken(token);

        return response;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/userinfo")
    public User userinfo() {
        Boolean isTokenValid = authService.isTokenValid("token");
        if (!isTokenValid) {
            throw new Error("Token is invalid");
        }

        User user = new User();
        return user;
    }
}
