package com.github.zz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope//自动刷新配置
public class ConfigClientController {
    @Value("${msg}")
    private String msg;  //要访问的3344上的信息

    @GetMapping("/getConfigMsg")	//请求地址
    public String getConfigMsg(){
        return msg;
    }
}
