package com.example.showselfdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.showselfdemo.mapper")
public class ShowselfdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowselfdemoApplication.class, args);
    }

}
