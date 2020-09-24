package com.bsoft.service;

import com.bsoft.entity.Payment;
import com.bsoft.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-SERVICE") //指定调用哪个微服务
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}") //哪个地址
     CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping(value = "/payment/getAllPayment") //哪个地址
    CommonResult getAllPayment();

    @GetMapping(value="/payment/timeout")
    String timeout();
}