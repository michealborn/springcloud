package com.github.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3002 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3002.class,args);
    }
}
