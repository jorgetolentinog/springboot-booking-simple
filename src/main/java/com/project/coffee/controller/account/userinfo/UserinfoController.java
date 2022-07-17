package com.project.coffee.controller.account.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.token.TokenPayload;
import com.project.coffee.service.token.TokenService;

@RestController
@RequestMapping("/account")
public class UserinfoController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/userinfo")
    public UserinfoResponse userinfo(@RequestHeader("authorization") String token) {
        TokenPayload tokenPayload = tokenService.decode(token);
        User user = userRepository.findUserById(tokenPayload.getUserId());

        UserinfoResponse response = new UserinfoResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setAddress(user.getAddress());
        response.setEmail(user.getEmail());

        return response;
    }
}
