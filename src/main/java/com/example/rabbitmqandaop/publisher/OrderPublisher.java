package com.example.rabbitmqandaop.publisher;

import com.example.rabbitmqandaop.config.ConfigurationRabbitMQAndAOP;
import com.example.rabbitmqandaop.dto.Order;
import com.example.rabbitmqandaop.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/place/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setOrderId(UUID.randomUUID().toString());
        //restaurantservice
        //payment service
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        template.convertAndSend(ConfigurationRabbitMQAndAOP.EXCHANGE, ConfigurationRabbitMQAndAOP.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}