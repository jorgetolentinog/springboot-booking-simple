package com.project.coffee.usercase.account.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.token.TokenPayload;
import com.project.coffee.service.token.TokenService;

@Service
public class UserInfoUseCase {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public UserinfoResponse userinfo(String token) {
        TokenPayload tokenPayload = tokenService.decode(token);
        User user = userRepository.findById(tokenPayload.getUserId());

        UserinfoResponse response = new UserinfoResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setAddress(user.getAddress());
        response.setEmail(user.getEmail());

        return response;
    }
}
