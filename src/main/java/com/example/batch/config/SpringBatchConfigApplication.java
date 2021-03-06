package com.example.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing      // 배치 기능 활성화
@SpringBootApplication
public class SpringBatchConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchConfigApplication.class, args);
    }

}
