package com.project.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.usercase.account.login.LoginRequest;
import com.project.coffee.usercase.account.login.LoginResponse;
import com.project.coffee.usercase.account.login.LoginUseCase;
import com.project.coffee.usercase.account.register.RegisterRequest;
import com.project.coffee.usercase.account.register.RegisterUserCase;
import com.project.coffee.usercase.account.userinfo.UserInfoUseCase;
import com.project.coffee.usercase.account.userinfo.UserinfoResponse;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    private LoginUseCase loginUseCase;

    @Autowired
    private RegisterUserCase registerUserCase;

    @Autowired
    private UserInfoUseCase userInfoUseCase;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginUseCase.login(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {
        registerUserCase.register(request);
    }

    @GetMapping("/userinfo")
    public UserinfoResponse userinfo(@RequestHeader("authorization") String token) {
        return userInfoUseCase.userinfo(token);
    }
}
