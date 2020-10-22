package com.bsoft.service;

import com.bsoft.entity.Payment;
import com.bsoft.util.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-payment") //指定调用哪个微服务
public interface PaymentFeignService {
    @GetMapping(value = "/zk/get") //哪个地址
     CommonResult<String> getPayment();

    @GetMapping(value = "/zk/getAll") //哪个地址
    CommonResult getAllPayment();

}