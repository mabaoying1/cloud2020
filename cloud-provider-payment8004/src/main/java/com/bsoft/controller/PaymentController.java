package com.bsoft.controller;

import com.bsoft.entity.Payment;
import com.bsoft.util.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/zk")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value="/get")
    public CommonResult<String> paymentZk(){
        return new CommonResult(200, "查询成功!"+"serverPort:=="+serverPort, UUID.randomUUID().toString());
    }

    @GetMapping(value="/getAll")
    public CommonResult<List> paymentZkList(){
        List<Payment> list=new ArrayList<>();
        Payment payment;
        for(int i=1;i<=5;i++){
            payment=new Payment();
            payment.setId(Long.valueOf(i)).setSerial("描述"+i);
            list.add(payment);
        }
        return new CommonResult(200, "查询成功!"+"serverPort:=="+serverPort, list);
    }
}
