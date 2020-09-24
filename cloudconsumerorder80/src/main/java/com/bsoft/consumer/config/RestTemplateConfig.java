package com.bsoft.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
   // @LoadBalanced  不使用ribbon自带的负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

  /*  @Bean
    public IRule muRule(){
        //随机
        //return new RandomRule();
        //先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
        return new RetryRule();
    }*/
}
