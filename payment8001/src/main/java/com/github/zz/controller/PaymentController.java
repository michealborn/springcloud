package com.github.zz.controller;

import com.github.zz.entity.CommonResult;
import com.github.zz.entity.Payment;
import com.github.zz.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${server.port}")
    String serverPort;
    @Autowired
    DiscoveryClient discoveryClient;



    //只传给前端CommonResult，不需要前端了解其他的组件
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if(result > 0){
            return new CommonResult(200,"插入数据成功",result);
        }else{
            return new CommonResult(444,"插入数据失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        log.info("*****查询结果："+payment);
        payment.setSerial(payment.getSerial()+serverPort);
        if(payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID："+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        //获得所有服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***service:"+service);
        }
        List<ServiceInstance> payment = discoveryClient.getInstances("PAYMENT");
        for (ServiceInstance serviceInstance : payment) {
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/timeout")
    public String timeout(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
