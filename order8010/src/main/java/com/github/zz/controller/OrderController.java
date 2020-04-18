package com.github.zz.controller;
import com.github.zz.entity.CommonResult;
import com.github.zz.entity.Payment;
import com.github.zz.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentHystrixOk(@PathVariable("id") Integer id){
        String s = paymentFeignService.paymentHystrixOk(id);
        return s;
    }

//    @HystrixCommand(fallbackMethod = "TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    public String paymentHystrixTimeout(@PathVariable("id") Integer id){
        String s = paymentFeignService.paymentHystrixTimeout(id);
        return s;
    }

    public String TimeOutHandler(@PathVariable("id") Integer id){
        return "8009支付服务嗝屁了";
    }


    //global fallback
    public String globalFallback(){
        return "globalFallback";
    }

}