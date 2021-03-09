package com.lds.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.lds.springcloud.dao"})
public class UserManagerService {
    public static void main(String[] args) {
        SpringApplication.run(UserManagerService.class, args);
    }
}
