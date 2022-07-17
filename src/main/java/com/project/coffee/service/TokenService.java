package com.project.coffee.service;

public interface TokenService {
    public String create();
    public Boolean isValid(String token);
}
