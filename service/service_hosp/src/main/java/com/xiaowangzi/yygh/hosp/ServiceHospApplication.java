package com.xiaowangzi.yygh.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @EnableDiscoveryClient :将服务注册至Nacos中
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xiaowangzi")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.xiaowangzi")
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
