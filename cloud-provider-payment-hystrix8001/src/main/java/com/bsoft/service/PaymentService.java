package com.bsoft.service;

import com.bsoft.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问，肯定ok的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_OK,id: "+id+"\t"+"哈哈!";
    }

    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()+" paymentInfo_TimeOut,id: "+id+"\t"+"哈哈!"+"耗时 :"+timeNumber+"秒钟";
    }
}