package com.bsoft.controller;

import com.bsoft.entity.Payment;
import com.bsoft.service.PaymentFeignService;
import com.bsoft.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value="/consumer")
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value="/payment/getAllPayment")
    public CommonResult getAllPayment(){
      return paymentFeignService.getAllPayment();
    }

    @GetMapping(value="/payment/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }
}