package com.niit.Customer.service;

import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;

import java.util.List;

public interface CustomerService {
    public User addCustomer(User user) throws UserAlreadyExistException;
    public List<User> getAll();
    public String deleteCustomer(Integer customerId) throws UserNotFoundException;
    public List<User> getAllTheDetailsWhoHaveBoughtSamsung(String productName);
}
