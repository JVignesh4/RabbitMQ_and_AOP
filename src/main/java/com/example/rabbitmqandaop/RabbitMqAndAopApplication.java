package com.example.rabbitmqandaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RabbitMqAndAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqAndAopApplication.class, args);
    }

}
