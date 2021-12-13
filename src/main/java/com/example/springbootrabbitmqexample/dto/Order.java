package com.example.springbootrabbitmqexample.dto;

public class Order {
    
    private String orderId;
    private String name;
    private int qty;
    private double price;
    
    public Order() {
        this.orderId = "no-id";
        this.name = "";
        this.qty = -1;
        this.price = 0;
    }
    public Order(String id, String n, int q, double p) {
        this.orderId = id;
        this.name = n;
        this.qty = q;
        this.price = p;
    }

    // setter
    public void setOrderId(String id) {
        this.orderId = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    // getter
    public String getOrderId() {
        return this.orderId;
    }
    public String getName() {
        return this.name;
    }
    public int getQty() {
        return this.qty;
    }
    public double getPrice() {
        return this.price;
    }
  
}
