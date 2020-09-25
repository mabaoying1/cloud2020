package com.bsoft.controller;

import com.bsoft.entity.Payment;
import com.bsoft.service.PaymentService;
import com.bsoft.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("{server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id")Integer id){
        String result=paymentService.paymentInfo_OK(id);
        log.info("****result: "+result);
        return  result;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result=paymentService.paymentInfo_TimeOut(id);
        log.info("****result: "+result);
        return  result;
    }

}