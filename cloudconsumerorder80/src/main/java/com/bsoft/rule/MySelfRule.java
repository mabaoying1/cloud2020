package com.bsoft.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 这个自定义配置类不能放在 @ComponentScan 所扫描的当前包下以及子包下，否则自定义的配置类
 * 就会被所有的 Ribbon 客户端所共享，达不到特殊化定制的目的了。
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule muRule(){
        //随机
        return new RandomRule();
    }
}