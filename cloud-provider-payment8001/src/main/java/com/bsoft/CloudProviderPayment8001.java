package com.bsoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.bsoft.dao")
@EnableEurekaClient//注解@EnableEurekaClient 表明自己是一个eurekaclient
public class CloudProviderPayment8001 {

	public static void main(String[] args) {
		SpringApplication.run(CloudProviderPayment8001.class, args);
	}

}
