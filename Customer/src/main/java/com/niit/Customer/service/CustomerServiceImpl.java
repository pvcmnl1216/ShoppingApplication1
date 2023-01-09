/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.service;

import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;
import com.niit.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public User addCustomer(User user) throws UserAlreadyExistException {
    if (customerRepository.findById(user.getUserId()).isEmpty()){
        User user1 =customerRepository.save(user);
        return user1;
    }
        throw new UserAlreadyExistException();
    }

    @Override
    public List<User> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public String deleteCustomer(Integer customerId) throws UserNotFoundException {
        if (customerRepository.findById(customerId).isEmpty()){
            throw new UserNotFoundException();
        }
       customerRepository.deleteById(customerId);
        return "Deleetd Successfully";
    }

    @Override
    public List<User> getAllTheDetailsWhoHaveBoughtSamsung(String productName) {
        return customerRepository.getAllTheDetailsWhoHaveBoughtSamsung(productName);
    }
}
