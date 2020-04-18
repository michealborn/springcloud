package com.github.zz.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentService {



    //=========服务降级==========
    public String paymentInfoOk(Integer id){
        return "线程池   "+Thread.currentThread().getName()+"  paymentInfoOk,id   "+id;
    }


    @HystrixCommand(fallbackMethod = "TimeOutHandler",commandProperties = {
            //当前方法不可用了，超时/报异常/使用fallbackMethod里的方法处理并返回
            //设置这个线程的超时时间是3s，3s内是正常的业务逻辑，超过3s调用fallbackMethod指定的方法进行处理
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })
    public String paymentInfoTimeOut(Integer id){
//        int a = 10/0;
        try {
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池   "+Thread.currentThread().getName()+"  paymentInfoTimeOut,id   "+id;
    }

    public String TimeOutHandler(Integer id){
        return "线程池   "+Thread.currentThread().getName()+"  8009TimeOutHandler,id   "+id;
    }



    //========服务熔断=========

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            //是否开启断路器
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            //请求次数
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间窗口期(时间范围)
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //失败率达到多少后
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
            //合起来的意思是 开启断路器后在10000ms内10次请求有60%都失败了就触发
            // (HystrixCommandProperties.class)内有所有属性解释
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("不能为负数id:---"+id);
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"  调用成功,id   "+uuid;
    }

    public String paymentCircuitBreakerFallBack(@PathVariable("id") Integer id){
        return "不能为负数fallback:ID----"+id;
    }
}
