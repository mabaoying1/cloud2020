package com.bsoft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//刷新功能 @RefreshScope的作用就是自动获悉刷新的内容,必须是Post请求，使用curl命令
@RefreshScope
public class ConfigClientController {

    @Value("{server.port}")
    private String serverPort;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return "serverPort:"+serverPort+"\t\n\n  configInfo: "+configInfo;
    }
}