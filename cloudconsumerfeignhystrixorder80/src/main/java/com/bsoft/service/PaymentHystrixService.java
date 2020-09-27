package com.bsoft.service;

import com.bsoft.entity.Payment;
import com.bsoft.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT") //指定调用哪个微服务
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id")Integer id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id")Integer id);
}