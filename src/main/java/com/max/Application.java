package com.max;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.max.mapper") /* tk.mybatis.spring.annotation.MapperScan;  */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
