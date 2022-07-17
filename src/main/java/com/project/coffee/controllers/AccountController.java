package com.project.coffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.entities.User;
import com.project.coffee.services.user.UserService;

@RestController
@RequestMapping("/account")
public class AccountController {
    
    @Autowired
    private UserService userService;

    @PostMapping("")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }
}
