package com.bsoft.controller;

import com.bsoft.consumer.lb.LoadBalancer;
import com.bsoft.entity.Payment;
import com.bsoft.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    //public static final String PAYMENT_URL= "http://localhost:8001";
    //通过在eureka上注册过的微服务名称调用
    public static final String PAYMENT_URL= "http://CLOUD-PROVIDER-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("*******消费者启动创建订单*******");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/payment/getAllPayment")
    public CommonResult<List> getAllPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getAllPayment",CommonResult.class);
    }

    @GetMapping("/payment/getForEntity")
    public CommonResult<List> getForEntity(){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getAllPayment",CommonResult.class);
        System.out.println(forEntity);
        System.out.println("---------------");
        if(forEntity.getStatusCode().is2xxSuccessful()){
            System.out.println(forEntity.getBody());
            return forEntity.getBody();
        }else{
            return new CommonResult<>(444,"调用失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/payment/put")
    public CommonResult<Payment> put(Payment payment){
        log.info("*******消费者启动更新订单*******");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/put",payment,CommonResult.class);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for (String element: services) {
            log.info("*****element"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 自定义负载均衡规则
     */
    @Resource
    private LoadBalancer loadBalancer;

    @GetMapping("/payment/lb")
    public  CommonResult<List>  lb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if(instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/getAllPayment",CommonResult.class);
    }

    /**
     * 链路监控
     * @return
     */
    @GetMapping(value="/payment/zipkin")
    public String zipkin(){
        log.info("*******链路监控*******");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",String.class);
    }

}
