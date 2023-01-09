package com.niit.Customer.repository;

import com.niit.Customer.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CustomerRepository extends MongoRepository<User,Integer> {

    @Query("{'product.productName':{$in:[?0]}}")
    public List<User> getAllTheDetailsWhoHaveBoughtSamsung(String productName);
}
