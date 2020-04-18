package com.github.zz.controller;

import com.github.zz.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentHystrixOk(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfoOk(id);
        log.info("****"+s);
        return s;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentHystrixTimeout(@PathVariable("id") Integer id){
        String s = paymentService.paymentInfoTimeOut(id);
        log.info("****"+s);
        return s;
    }

    @GetMapping(value = "/payment/hystrix/paymentCircuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String s = paymentService.paymentCircuitBreaker(id);
        return s;
    }

}
