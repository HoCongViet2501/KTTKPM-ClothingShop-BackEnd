package com.se.backend.ecommerceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EcommerceAppBackEndApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(EcommerceAppBackEndApplication.class, args);
    }
    
}
