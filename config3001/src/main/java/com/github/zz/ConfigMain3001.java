package com.github.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMain3001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3001.class,args);
    }
}
