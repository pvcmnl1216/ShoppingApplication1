///*
// * Author Name: Philip Meshach
// * Date: 30-12-2022
// * Praise The Lord
// */
//package com.niit.Customer.repository;
//
//import com.niit.Customer.domain.Customer;
//import com.niit.Customer.domain.Product;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class RepositoryTest {
//    @Autowired
//    private CustomerRepository customerRepository;
//    private Customer customer;
//    private Product product;
//
//    @BeforeEach
//    public void setUp(){
//        this.product = new Product(12,"Mobile","Android");
//        this.customer = new Customer(1,"Who","121212211",this.product);
//    }
//    @Test
//    public void addDetails(){
//        customerRepository.save(customer);
//       Customer c1 = customerRepository.findById(customer.getCustomerId()).get();
//       assertEquals(customer,c1);
//    }
//    @Test
//    public void kickCustomerFromShop(){
//        this.customer = new Customer(141,"Dai","only email",this.product);
//        customerRepository.insert(customer);
//        Customer c2 = customerRepository.findById(customer.getCustomerId()).get();
//        customerRepository.delete(c2);
//        assertEquals(Optional.empty(),customerRepository.findById(c2.getCustomerId()));
//
//    }
//    @Test
//    public void getDetails(){
//        customerRepository.deleteAll();
//        this.product = new Product(12,"Tv","Electronics");
//        this.customer = new Customer(11,"per vaikala","no calls",this.product);
//        customerRepository.insert(customer);
//        List<Customer>s3 = customerRepository.findAll();
//        assertEquals(1,s3.size());
//    }
//
//    @AfterEach
//    public void tearDown(){
//        this.product = null;
//        this.customer = null;
//    }
//}
