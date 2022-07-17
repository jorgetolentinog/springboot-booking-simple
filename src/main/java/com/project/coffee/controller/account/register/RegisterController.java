package com.project.coffee.controller.account.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.model.User;
import com.project.coffee.repository.UserRepository;

@RestController
@RequestMapping("/account")
public class RegisterController {

    @Autowired
    private UserRepository userService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());

        userService.save(user);
    }
}
