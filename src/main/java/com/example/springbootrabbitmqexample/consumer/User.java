package com.example.springbootrabbitmqexample.consumer;

import com.example.springbootrabbitmqexample.config.MessagingConfig;
import com.example.springbootrabbitmqexample.dto.OrderStatus;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {
    
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message recieved from queue: " + orderStatus + 
        "\n+------------------------\n| # order: " + orderStatus.getOrder().getOrderId() + 
        "\n| name order: " + orderStatus.getOrder().getName() +
        "\n| quantity: " + orderStatus.getOrder().getQty() +
        "\n| price: " + orderStatus.getOrder().getPrice() +
        "\n+----------------");
    }
}
