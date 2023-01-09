/*
 * Author Name: Philip Meshach
 * Date: 02-01-2023
 * Praise The Lord
 */
package com.niit.Customer.service;

import com.niit.Customer.domain.User;
import com.niit.Customer.domain.Product;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;
import com.niit.Customer.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;
    private User user;
    private Product product;

    @BeforeEach
    public void setUp() {
        this.product = new Product(12, "Mobile", "Android");
        this.user = new User(1, "Who", "121212211", this.product);
    }

    @AfterEach
    public void tearDown() {
        this.product = null;
        this.user = null;
    }

    @Test
    public void givenCustomerToSaveReturnSavedCustomerSuccess() throws UserAlreadyExistException {
        when(customerRepository.findById(user.getUserId())).thenReturn(Optional.ofNullable(null));
        when(customerRepository.save(user)).thenReturn(user);
        assertEquals(user, customerService.addCustomer(user));
    }

    @Test
    public void givenCustomerToSaveReturnCustomerFailure() {
        when(customerRepository.findById(user.getUserId())).thenReturn(Optional.ofNullable(user));
        assertThrows(UserAlreadyExistException.class, () -> customerService.addCustomer(user));
    }

    @Test
    public void givenCustomerToDeleteShouldDeleteSuccess() throws UserNotFoundException {
        when(customerRepository.findById(user.getUserId())).thenReturn(Optional.ofNullable(user));
        String flag = customerService.deleteCustomer(user.getUserId());
        assertEquals("Deleetd Successfully", flag);
    }
}
