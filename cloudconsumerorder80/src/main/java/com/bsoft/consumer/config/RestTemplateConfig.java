package com.bsoft.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate对象注册到容器中(创建 RestTemplate模板加入spring的bean中)
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    //开启RestTemplate负载均衡功能
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //设置负载均衡策略
  /*  @Bean
    public IRule muRule(){
    //使用我们选择的算法替代默认算法
        //随机
        //return new RandomRule();
        //先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
        return new RetryRule();
    }
*/
    /*
      ######使用自定义的ribbon负载均衡#############
     */
   /* @Bean
    //@LoadBalanced //不使用自带的负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
 */

}
