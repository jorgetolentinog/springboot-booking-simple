package com.project.coffee.usercase.account.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.token.TokenPayload;
import com.project.coffee.service.token.TokenService;

@Service
public class LoginUseCase {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public LoginResponse login(LoginRequest request) {
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
