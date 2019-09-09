package com.maggie.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.maggie.hrm.mapper")
public class SitPageConfig9006Application {
    public static void main(String[] args) {
        SpringApplication.run(SitPageConfig9006Application.class,args);
    }
}
