package com.bsoft.controller;

import com.bsoft.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value="/sendMessage")
    public String sendMessage(){
        String result;
        try {
            iMessageProvider.send();
            result="发送成功";
        }catch (Exception e){
            result="发送失败,"+e.getMessage();
        }
        return result;
    }
}
