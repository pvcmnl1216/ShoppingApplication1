///*
// * Author Name: Philip Meshach
// * Date: 02-01-2023
// * Praise The Lord
// */
//package com.niit.Customer.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.niit.Customer.domain.Customer;
//import com.niit.Customer.domain.Product;
//import com.niit.Customer.exception.UserAlreadyExistException;
//import com.niit.Customer.exception.UserNotFoundException;
//import com.niit.Customer.service.CustomerServiceImpl;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.*;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(MockitoExtension.class)
//public class CustomerControllerTest {
//    @Mock
//    CustomerServiceImpl customerService;
//    @InjectMocks
//    CustomerController customerController;
//    @Autowired
//    MockMvc mockMvc;
//    private Customer customer,customer1,customer2;
//    private Product product,product1,product3;
//    List<Customer> customerList;
//    @BeforeEach
//    public void setUp(){
//        this.product = new Product(12, "Mobile", "Android");
//        this.customer = new Customer(1, "Who", "121212211", this.product);
//        this.product1=new Product(70,"Samsung SmartTV","Made in India");
//        this.customer1=new Customer(102,"Ramesh","7788154656L",this.product1);
//        this.product3=new Product(70,"Samsung SmartTV","Made in India");
//        this.customer2=new Customer(102,"Ramesh","7788154656L",this.product1);
//        customerList = Arrays.asList(customer, customer1,customer2);
//        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
//    }
//    @AfterEach
//    public void tearDown() {
//        this.product = null;
//        this.customer = null;
//    }
//    @Test
//    public void givenCustomerToSaveReturnSavedCustomer() throws Exception {
//        when(customerService.addCustomer(any())).thenReturn(customer);
//        mockMvc.perform(post("/api/v1/cust")
//        .contentType(MediaType.APPLICATION_JSON).content(convertJsonToString(customer))).
//                andExpect(status().isOk()).
//                andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void givenCustomerToSaveReturnSavedCustomerFailure() throws Exception {
//        when(customerService.addCustomer(any())).thenReturn(null);
//        mockMvc.perform(post("/api/v1/cust").contentType(MediaType.APPLICATION_JSON).
//                content(convertJsonToString(customer))
//        ).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void givenCustomerToDeleteCustomer() throws Exception {
//        String result="customer deleted succefully";
//        when(customerService.deleteCustomer(anyInt())).thenReturn(result);
//        mockMvc.perform(delete("/api/v1/customs/1").
//                contentType(MediaType.APPLICATION_JSON)).
//                andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void givenCustomerToDeleteCustomerFailure() throws Exception {
//        when(customerService.deleteCustomer(anyInt())).thenThrow(UserNotFoundException.class);
//        mockMvc.perform(delete("/api/v1/customs/1").
//                        contentType(MediaType.APPLICATION_JSON)).
//                andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        when(customerService.getAll()).thenReturn(customerList);
//        mockMvc.perform(get("/api/v1/custom").
//                contentType(MediaType.APPLICATION_JSON).
//                content(convertJsonToString(customer))).
//                andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//    }
//
//    public static String convertJsonToString(final Object obj) throws JsonProcessingException {
//        String result;
//        ObjectMapper objectMapper = new ObjectMapper();
////        try {
//            String json = objectMapper.writeValueAsString(obj);
//            result = json;
////        } catch (JsonProcessingException e) {
////           throw new RuntimeException(e);
//////            e.printStackTrace();
//////            result = "Json parser error";
////        }
//        return result;
//    }
//}
//
