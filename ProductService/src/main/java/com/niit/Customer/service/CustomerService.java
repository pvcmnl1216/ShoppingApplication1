package com.niit.Customer.service;

import com.niit.Customer.domain.Product;
import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;

import java.util.List;

public interface CustomerService {
    public User addCustomer(User user) throws UserAlreadyExistException;

    public User saveUserMovieToList(Product product, String email) throws UserNotFoundException;
    public List<Product> getAll(String email) throws UserAlreadyExistException;
    public String deleteCustomer(String lastNama) throws UserNotFoundException;
    public List<User> getAllTheDetailsWhoHaveBoughtSamsung(String productName);
}
