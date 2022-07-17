package com.project.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.User;
import com.project.coffee.payload.LoginRequest;
import com.project.coffee.payload.LoginResponse;
import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.AuthService;
import com.project.coffee.service.TokenService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserRepository userService;

    @Autowired
    private AuthService authService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = authService.authenticate("email", "password");
        if (user == null) {
            throw new Error("Invalid username or password");
        }

        String token = tokenService.create();

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
        Boolean isTokenValid = tokenService.isValid("token");
        if (!isTokenValid) {
            throw new Error("Token is invalid");
        }

        User user = new User();
        return user;
    }
}
