package com.waldhauser.tasklist.security;


import com.waldhauser.tasklist.user.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtMaker{

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expiration = 1000 * 60 * 60 * 1; // 1 hour expiration

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .addClaims(Map.of("uuid", user.getId()))
                .signWith(key)
                .compact();
    }
}
