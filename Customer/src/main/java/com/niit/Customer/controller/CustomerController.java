/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.controller;

import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;
import com.niit.Customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/cust")
    public ResponseEntity<?> add(@RequestBody User user) throws UserAlreadyExistException {
        return new ResponseEntity<>(customerService.addCustomer(user), HttpStatus.OK);
    }
    @GetMapping("/custom")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(customerService.getAll(),HttpStatus.OK);
    }
    @DeleteMapping("/customs/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) throws UserNotFoundException {
        return new ResponseEntity<>(customerService.deleteCustomer(id),HttpStatus.OK);
    }
    @GetMapping("/custm/{product}")
    public ResponseEntity<?> getByProduct(@PathVariable String product){
        return new ResponseEntity<>(customerService.getAllTheDetailsWhoHaveBoughtSamsung(product),HttpStatus.OK);
    }
}
