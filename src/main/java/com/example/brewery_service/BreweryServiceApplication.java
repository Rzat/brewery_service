package com.example.brewery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example.brewery_service.web.mapper"})
public class BreweryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BreweryServiceApplication.class, args);
        System.out.println("****Starting**");
    }

}
