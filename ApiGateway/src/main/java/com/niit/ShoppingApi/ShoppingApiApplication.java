package com.niit.ShoppingApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShoppingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApiApplication.class, args);
	}

}
