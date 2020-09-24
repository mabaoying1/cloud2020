package com.bsoft.consumer.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *  模拟 ILoadBalancer 的接口，选择哪一个负载算法和机器
 */
public interface LoadBalancer {
    //获取eureka上的活着的机器总数
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}