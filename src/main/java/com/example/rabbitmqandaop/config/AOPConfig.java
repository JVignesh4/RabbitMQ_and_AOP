package com.example.rabbitmqandaop.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AOPConfig {

    @Before(value = "execution(* com.example.rabbitmqandaop.config.ConfigurationRabbitMQAndAOP.*())")
    public void beforeAdvice() {
        System.out.println("Before method: Before Order Placing");
    }


    @After(value = "execution(* com.example.rabbitmqandaop.config.ConfigurationRabbitMQAndAOP.*())")
    public void afterAdvice() {
        System.out.println("After method: Order Placed");

    }
}
