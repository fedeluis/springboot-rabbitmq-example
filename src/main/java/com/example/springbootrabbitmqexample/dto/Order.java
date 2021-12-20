package com.example.springbootrabbitmqexample.dto;

import javax.persistence.*;

import com.example.springbootrabbitmqexample.publisher.OrdersID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString

@Entity
@Table(name = "orders")
@IdClass(OrdersID.class)
public class Order {
    
    @Id
    private String orderId;
    @Id
    private String restaurant;

    private String name;
    private int qty;
    private double price;
  
}
