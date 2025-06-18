package com.example.smsless;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.smsless.mapper")
public class SmslessApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmslessApplication.class, args);
    }

}

