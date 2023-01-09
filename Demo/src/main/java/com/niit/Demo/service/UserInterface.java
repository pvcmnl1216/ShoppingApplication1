package com.niit.Demo.service;

import com.niit.Demo.domain.User;

import java.util.List;

public interface UserInterface {

    public User addUser(User user);

    public List<User> getAll();

    public String deleteUser(String email);

    public User updateUser(User user);
    public User loginCheck(String email,String password);
}
