package com.project.coffee.services.auth;

public interface AuthService {
    public String authenticate(String email, String password);

    public Boolean isTokenValid(String token);
}
