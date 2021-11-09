package com.niit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.niit.dao")
public class FeedbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeedbackApplication.class,args);
    }
}
