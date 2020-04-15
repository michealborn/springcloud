package com.github.myrule;


import com.github.zz.lb.MyLoadBalancer2;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义Ribbon时，被扫描的包路劲不能是在@ComponentScan扫描的包及子包下，需要单独新建一个路径
//在主启动类上加上@RibbonClient
@Configuration
public class MyRule {
    @Bean
    public IRule myrule(){
//        return new RandomRule(); //帮你实现好的其他的策略，readme里有更详细的
        return new MyLoadBalancer2(); //自己实现的策略
    }
}
