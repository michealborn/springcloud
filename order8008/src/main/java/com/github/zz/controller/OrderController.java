package com.github.zz.controller;
import com.github.zz.entity.CommonResult;
import com.github.zz.entity.Payment;
import com.github.zz.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    PaymentFeignService paymentFeignService;


    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        CommonResult<Payment> byId = paymentFeignService.getPaymentById(id);
        return byId;
    }

    @GetMapping(value = "/consumer/payment/timeout")
    public String timeout(){
        return paymentFeignService.timeout();
    }
}