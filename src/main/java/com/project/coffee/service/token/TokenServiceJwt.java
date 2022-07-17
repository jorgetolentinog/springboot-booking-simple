package com.project.coffee.service.token;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenServiceJwt implements TokenService {
    private Logger logger = Logger.getLogger(TokenServiceJwt.class.getName());
    private String jwtSecretKey = "2HFI23KBGDhroHqk7WuDYuK4HLmjhZ83";

    @Override
    public String encode(TokenPayload payload) {
        return Jwts.builder()
                .claim("userId", payload.getUserId())
                .signWith(getSecurityKey())
                .compact();
    }

    @Override
    public TokenPayload decode(String token) {
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(getSecurityKey()).build().parseClaimsJws(token);
        Long userId = claims.getBody().get("userId", Long.class);

        TokenPayload payload = new TokenPayload();
        payload.setUserId(userId);

        return payload;
    }


    @Override
    public Boolean isValid(String token) {
        Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(getSecurityKey()).build().parseClaimsJws(token);
        logger.info(String.format("isValid claims %s", claims));

        String sub = claims.getBody().get("sub", String.class);
        logger.info(String.format("isValid claims sub %s", sub));

        return true;
    }

    private Key getSecurityKey() {
        byte[] keyBytes = jwtSecretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
