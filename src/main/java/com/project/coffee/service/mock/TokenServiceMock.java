package com.project.coffee.service.mock;

import org.springframework.stereotype.Service;

import com.project.coffee.service.TokenService;

@Service
public class TokenServiceMock implements TokenService {

    @Override
    public String create() {
        return "1234.1234.1234";
    }

    @Override
    public Boolean isValid(String token) {
        return true;
    }
}
