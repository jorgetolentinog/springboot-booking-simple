package com.project.coffee.controller.account.userinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.TokenService;

@RestController
@RequestMapping("/account")
public class UserinfoController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/userinfo")
    public UserinfoResponse userinfo() {
        Boolean isTokenValid = tokenService.isValid("token");
        if (!isTokenValid) {
            throw new Error("Token is invalid");
        }

        User user = userRepository.findUserById(1L);

        UserinfoResponse response = new UserinfoResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setAddress(user.getAddress());
        response.setEmail(user.getEmail());

        return response;
    }
}
