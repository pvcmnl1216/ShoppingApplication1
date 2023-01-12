package com.niit.Demo.service;

import com.niit.Demo.domain.User;

import java.util.Map;

public interface GenerateToken {
    public Map<String,String> generateToken(User user);
}
