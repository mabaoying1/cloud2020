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

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("******插入结果" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功!,serverPort:="+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败!"+"serverPort:=="+serverPort, null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询"+id+"serverPort:=="+serverPort);
        if (payment != null) {
            return new CommonResult(200, "查询成功!"+"serverPort:=="+serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID:" + id+"serverPort:=="+serverPort, null);
        }
    }

    @GetMapping(value="/getAllPayment")
    public CommonResult getAllPayment(){
        List<Payment> list=paymentService.getPayment();
        if (list!=null && list.size()>0) {
            return new CommonResult(200, "查询成功!"+"serverPort:=="+serverPort, list);
        } else {
            return new CommonResult(444, "没有对应记录 serverPort:=="+serverPort, null);
        }
    }

    @GetMapping(value="/timeout")
    public String timeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody Payment payment){
        int result = paymentService.update(payment);
        log.info("******更新结果,serverPort:\"+serverPort" + result);
        if (result > 0) {
            return new CommonResult(200, "更新数据库成功!"+"serverPort:=="+serverPort, result);
        } else {
            return new CommonResult(444, "更新数据库失败!"+"serverPort:=="+serverPort, null);
        }
    }

}