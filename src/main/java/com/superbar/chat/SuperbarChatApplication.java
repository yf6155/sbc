package com.superbar.chat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.superbar.chat.dao.dos.mapper"})
public class SuperbarChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperbarChatApplication.class, args);
    }

}
