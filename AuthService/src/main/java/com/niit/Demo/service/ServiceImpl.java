/*
 * Author Name: Philip Meshach
 * Date: 26-12-2022
 * Praise The Lord
 */
package com.niit.Demo.service;

import com.niit.Demo.domain.User;
import com.niit.Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements UserInterface {

    UserRepository userRepository;

    @Autowired
    public ServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addUser(User user) {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public String deleteUser(String email) {
        if (userRepository.findById(email).isEmpty()) {
            return "user does not exist";
        }
        userRepository.deleteById(email);
        return "delete successfully";
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.findById(user.getEmail()).isEmpty()) {
            return null;
        }
        User user1 = userRepository.findById(user.getEmail()).get();
        user1.setFirstName(user.getFirstName());
        user1.setLastNama(user.getLastNama());
        user1.setPassWord(user.getPassWord());
        return userRepository.save(user1);
    }

    @Override
    public User loginCheck(String email, String password) {
        if (userRepository.findById(email).isPresent()) {
            User user = userRepository.findById(email).get();
            if (user.getPassWord().equals(password)) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
