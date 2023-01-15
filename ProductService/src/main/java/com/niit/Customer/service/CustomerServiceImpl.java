/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.service;

import com.niit.Customer.config.ProductDTO;
import com.niit.Customer.domain.Product;
import com.niit.Customer.domain.User;
import com.niit.Customer.exception.UserAlreadyExistException;
import com.niit.Customer.exception.UserNotFoundException;
import com.niit.Customer.proxy.UserProxy;
import com.niit.Customer.repository.CustomerRepository;
import org.json.simple.JSONObject;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {

    UserProxy userProxy;
    CustomerRepository customerRepository;

    private RabbitTemplate rabbitTemplate;
    private DirectExchange directExchange;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, UserProxy userProxy, RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.customerRepository = customerRepository;
        this.userProxy = userProxy;
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }


    @Override
    public User addCustomer(User user) throws UserAlreadyExistException {
    if (customerRepository.findById(user.getFirstName()).isEmpty()){
        User user1 =customerRepository.save(user);
        userProxy.add(user1);
        return user1;
    }
        throw new UserAlreadyExistException();
    }

    @Override
    public User saveUserMovieToList(Product product, String email) throws UserNotFoundException {
        //  check user is present or not
        if(customerRepository.findById(email).isEmpty()){
            throw new UserNotFoundException();
        }
        // user present
        User result=customerRepository.findById(email).get();
        if(result.getProduct()!=null) {
            result.getProduct().add(product);
        }else{
            result.setProduct(new ArrayList<>());
            result.getProduct().add(product);
        }
        customerRepository.save(result);
        return result;
    }


    @Override
    public List<Product> getAll(String email) throws UserAlreadyExistException {

        if(customerRepository.findById(email).isEmpty()){
            throw new UserAlreadyExistException();
        }
        //if not exist
        List<Product> allMovies=customerRepository.findById(email).get().getProduct();
        List<Product> notUsed=new ArrayList<>();
        for(Product c: allMovies){
            if(!c.isUsed()){
                notUsed.add(c);
            }
        }

        //create jsonobject
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("product_list",notUsed);
        jsonObject.put("email",email);
        //create MovieDTO object

        ProductDTO productDTO=new ProductDTO(jsonObject);

        //exchange name ,routingkey,,DtoObject
        rabbitTemplate.convertAndSend(directExchange.getName(),"product_routing",productDTO);
        System.out.println("SEND SUCCEFULL"+directExchange.getName()+productDTO);
        return allMovies;
    }



    @Override
    public String deleteCustomer(String lastNama ) throws UserNotFoundException {
        if (customerRepository.findById(lastNama).isEmpty()){
            throw new UserNotFoundException();
        }
       customerRepository.deleteById(lastNama);
        return "Deleetd Successfully";
    }

    @Override
    public List<User> getAllTheDetailsWhoHaveBoughtSamsung(String productName) {
        return customerRepository.getAllTheDetailsWhoHaveBoughtSamsung(productName);
    }
}
