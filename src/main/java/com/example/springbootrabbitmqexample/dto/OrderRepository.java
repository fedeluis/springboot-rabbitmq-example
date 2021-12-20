package com.example.springbootrabbitmqexample.dto;

import com.example.springbootrabbitmqexample.publisher.OrdersID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,OrdersID> {
    
}
