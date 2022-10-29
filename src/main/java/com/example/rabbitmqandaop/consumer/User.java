package com.example.rabbitmqandaop.consumer;

import com.example.rabbitmqandaop.config.ConfigurationRabbitMQAndAOP;
import com.example.rabbitmqandaop.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

    @RabbitListener(queues = ConfigurationRabbitMQAndAOP.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message Received from queue : " + orderStatus);
    }
}