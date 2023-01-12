/*
 * Author Name: Philip Meshach
 * Date: 26-12-2022
 * Praise The Lord
 */
package com.niit.Demo.controller;

import com.niit.Demo.domain.User;
import com.niit.Demo.service.GenerateToken;
import com.niit.Demo.service.GenerateTokenImpl;
import com.niit.Demo.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    ServiceImpl service ;
    GenerateTokenImpl generateToken;
    @Autowired
    public UserController(ServiceImpl service, GenerateTokenImpl generateToken) {
        this.service = service;
        this.generateToken = generateToken;
    }

    @PostMapping("/register")
    public ResponseEntity<?>add(@RequestBody User user){
    return new ResponseEntity<>( service.addUser(user), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?>loginCheck(@RequestBody User user){
        User user1 = service.loginCheck(user.getEmail(),user.getPassWord());
        if(user1!=null){
            Map<String ,String >map = generateToken.generateToken(user1);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User Not Exist",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/user")
    public ResponseEntity<?>get(){
    return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("/user/{email}")
    public ResponseEntity<?>delete(@PathVariable  String email){
    return new ResponseEntity<>(service.deleteUser(email),HttpStatus.OK);
    }
    @PutMapping("/user")
    public ResponseEntity<?>update(@RequestBody User user){
    return new ResponseEntity<>(service.updateUser(user),HttpStatus.OK);
    }
}
