package com.example.springbootrabbitmqexample.publisher;

import com.example.springbootrabbitmqexample.config.MessagingConfig;
import com.example.springbootrabbitmqexample.dto.Order;
import com.example.springbootrabbitmqexample.dto.OrderRepository;
import com.example.springbootrabbitmqexample.dto.OrderStatus;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderPublisher {
    
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private OrderRepository orderRepo;

    @PostMapping(value="/{restName}",consumes = { MediaType.APPLICATION_JSON_VALUE })
    public HttpStatus bookOrder(@PathVariable String restName, @RequestBody Order order) {
        
        //order.setOrderId(UUID.randomUUID().toString());
        order.setRestaurant(restName);
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restName);
        
        try {
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
            orderRepo.save(order);
        } catch (AmqpException a) {
            // per rabbitMQ
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } catch(IllegalArgumentException e) {
            // per POST
            return HttpStatus.BAD_REQUEST;
        }
        
        return HttpStatus.OK;
    }

    @PutMapping(value="/{restName}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus changeOrder(@PathVariable String restName, @RequestBody Order order) {

        order.setRestaurant(restName);
        OrderStatus orderStatus = new OrderStatus(order, "PROCESS", "order placed succesfully in " + restName);

        try {
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
            orderRepo.save(order);
        } catch (AmqpException a) {
            // per rabbitMQ
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.OK;
    }

    @GetMapping(value="/{restName}/{ordId}")
    public String getOrder(@PathVariable String restName, @PathVariable String ordId) {
        Order order;
        OrdersID ordersID = new OrdersID(ordId,restName);

        try {
            order = orderRepo.getById(ordersID);
        } catch (Exception e) {
            return "order not found";
        }
        return order.toString();
    }

    @GetMapping(value="/list")
    public String getAll() {
        return orderRepo.findAll().toString();
    }
    
}
