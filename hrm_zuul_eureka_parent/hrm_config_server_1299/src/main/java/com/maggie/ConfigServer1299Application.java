package com.maggie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //加入注册中心
@EnableConfigServer //启用配置服务端
public class ConfigServer1299Application {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer1299Application.class,args);
    }
}
