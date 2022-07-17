package com.project.coffee.controller.account.login;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.service.token.TokenPayload;
import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.token.TokenService;

@RestController
@RequestMapping("/account")
public class LoginController {
    Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new Error("User not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            throw new Error("Password incorrect");
        }

        TokenPayload tokenPayload = new TokenPayload();
        tokenPayload.setUserId(user.getId());

        String token = tokenService.encode(tokenPayload);

        LoginResponse response = new LoginResponse();
        response.setToken(token);

        return response;
    }

}
