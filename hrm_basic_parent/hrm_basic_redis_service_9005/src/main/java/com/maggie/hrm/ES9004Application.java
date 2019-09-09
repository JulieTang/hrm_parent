package com.maggie.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ES9004Application {
    public static void main(String[] args) {
        SpringApplication.run(ES9004Application.class,args);
    }
}
