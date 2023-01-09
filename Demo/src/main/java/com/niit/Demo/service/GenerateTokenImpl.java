/*
 * Author Name: Philip Meshach
 * Date: 03-01-2023
 * Praise The Lord
 */
package com.niit.Demo.service;

import com.niit.Demo.domain.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class GenerateTokenImpl implements GenerateToken{
    @Override
    public Map<String, String> generateToken(User user) {
        String jwt = null;
        jwt = Jwts.builder().setSubject(user.getFirstName()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"security key").compact();
        Map<String,String>map = new HashMap<>();
        map.put("token",jwt);
        map.put("Message","User Logged In Successfully");
        return map;
    }
}
