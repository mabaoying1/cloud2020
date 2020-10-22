package com.bsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //该注解用于想使用consul或者zookeeper作为注册中心时注册服务
@EnableFeignClients
public class OrderZKMain80 {


    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain80.class,args);
    }
}
