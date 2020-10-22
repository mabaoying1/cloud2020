package com.bsoft.controller;

import com.bsoft.service.PaymentFeignService;
import com.bsoft.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/consumer")
@Slf4j
public class OrderZKController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/getPayment")
    public CommonResult<String> getPayment(){
       return paymentFeignService.getPayment();
    }

    @GetMapping(value = "/getAllPayment")
    public CommonResult<List> getAllPayment(){
        return paymentFeignService.getAllPayment();
    }

}
