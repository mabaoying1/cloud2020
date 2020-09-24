package com.bsoft.consumer;

import com.bsoft.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
//@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MySelfRule.class)
public class OrderMain8080 {
    public static void main( String[] args ) {
        SpringApplication.run(OrderMain8080.class,args);
    }
}
