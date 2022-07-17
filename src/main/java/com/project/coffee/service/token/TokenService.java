package com.project.coffee.service.token;

public interface TokenService {
    public String encode(TokenPayload payload);
    public TokenPayload decode(String token);
    public Boolean isValid(String token);
}
