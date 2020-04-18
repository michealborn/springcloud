package com.github.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
/**
 * 所有需要被hystrix监控的服务都需要加入如下pom依赖
 * <dependency>
 *     <groupId>org.springframework.boot</groupId>
 * 	   <artifactId>spring-boot-starter-actuator</artifactId>
 * </dependency>
 * */
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
