package com.project.coffee.service.mock;

import org.springframework.stereotype.Service;

import com.project.coffee.model.User;
import com.project.coffee.service.AuthService;

@Service
public class AuthServiceMock implements AuthService {

    @Override
    public User authenticate(String email, String password) {
        User user = new User();
        return user;
    }
}
