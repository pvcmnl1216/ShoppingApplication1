package com.niit.Customer.proxy;

import com.niit.Customer.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "userauth",url = "localhost:8084")
public interface UserProxy {

    @PostMapping("/api/v1/register")
    public ResponseEntity<?> add(@RequestBody User user);

}
