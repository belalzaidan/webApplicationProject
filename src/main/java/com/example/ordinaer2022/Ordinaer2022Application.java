package com.example.ordinaer2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Ordinaer2022Application {

    public static void main(String[] args) {
        SpringApplication.run(Ordinaer2022Application.class, args);
    }

}
