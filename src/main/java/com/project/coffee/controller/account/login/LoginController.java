package com.project.coffee.controller.account.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.User;
import com.project.coffee.service.AuthService;
import com.project.coffee.service.TokenService;

@RestController
@RequestMapping("/account")
public class LoginController {
    
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

}