package com.project.coffee.services.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceMock implements AuthService {
    @Override
    public String authenticate(String email, String password) {
        return "token.1234.5678";
    }

    @Override
    public Boolean isTokenValid(String token) {
        return true;
    }
}
