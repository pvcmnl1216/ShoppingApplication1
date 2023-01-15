/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.controller;

import com.niit.Customer.domain.Product;
import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;
import com.niit.Customer.proxy.UserProxy;
import com.niit.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class CustomerController {

    CustomerService customerService;
    private ResponseEntity<?> responseEntity;
    @Autowired
    public CustomerController( CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> add(@RequestBody User user) throws UserAlreadyExistException {
        return new ResponseEntity<>(customerService.addCustomer(user), HttpStatus.OK);
    }


    @PostMapping("/custom/{email}")
    public ResponseEntity<?> saveUserMovieToList(@RequestBody Product product, @PathVariable String email) throws UserNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(customerService.saveUserMovieToList(product, email), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
    @GetMapping("/custom/{email}")
    public ResponseEntity<?> getAll(@PathVariable String email) throws UserAlreadyExistException {

        return new ResponseEntity<>(customerService.getAll(email),HttpStatus.OK);
    }
    @DeleteMapping("/customs/{lastNama}")
    public ResponseEntity<?> delete(@PathVariable String lastNama) throws UserNotFoundException {
        return new ResponseEntity<>(customerService.deleteCustomer(lastNama),HttpStatus.OK);
    }
    @GetMapping("/custm/{product}")
    public ResponseEntity<?> getByProduct(@PathVariable String product){
        return new ResponseEntity<>(customerService.getAllTheDetailsWhoHaveBoughtSamsung(product),HttpStatus.OK);
    }
}
