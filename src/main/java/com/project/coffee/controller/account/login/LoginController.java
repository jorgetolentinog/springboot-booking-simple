package com.project.coffee.controller.account.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.service.token.TokenPayload;
//import com.project.coffee.model.User;
//import com.project.coffee.repository.UserRepository;
import com.project.coffee.service.token.TokenService;

@RestController
@RequestMapping("/account")
public class LoginController {

    //@Autowired
    //private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        /*User user = userRepository.findByEmail(request.getEmail());
        if (user.getPassword() != request.getPassword()) {
            throw new Error("Invalid username or password");
        }*/

        TokenPayload tokenPayload = new TokenPayload();
        tokenPayload.setUserId(5000L);

        String token = tokenService.encode(tokenPayload);

        LoginResponse response = new LoginResponse();
        response.setToken(token);

        return response;
    }

}
