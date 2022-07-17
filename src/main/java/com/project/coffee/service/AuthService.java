package com.project.coffee.service;

import com.project.coffee.model.User;

public interface AuthService {
    public User authenticate(String email, String password);
}
