package com.example.springbootrabbitmqexample.publisher;


import java.util.UUID;

import com.example.springbootrabbitmqexample.config.MessagingConfig;
import com.example.springbootrabbitmqexample.dto.Order;
import com.example.springbootrabbitmqexample.dto.OrderStatus;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderPublisher {
    
    @Autowired
    private RabbitTemplate template;

    @PostMapping(value="/{restaurantName}",consumes = { MediaType.APPLICATION_JSON_VALUE })
    public String bookOrder(@PathVariable String restaurantName, @RequestBody Order order) {
        
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restaurantName);
        
        try {
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        } catch (AmqpException a) {
            return "fail to convert and send message";
        }
        
        return "Recived order #" + order.getOrderId() + " that contains " + order.getName();
    }
    
}
