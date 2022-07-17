package com.project.coffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.coffee.entities.User;
import com.project.coffee.services.user.UserServiceMock;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceMock userService;

    @GetMapping("")
    public User create() {
        /*Map<String, String> map = new HashMap<String, String>();
        return map;*/

        return userService.findUserById(10L);
    }
}
