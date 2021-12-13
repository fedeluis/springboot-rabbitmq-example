package com.example.springbootrabbitmqexample.dto;

public class OrderStatus {
    
    private Order order;
    private String status;  // progress, completed
    private String message;

    public OrderStatus() {
        this.order = null;
        this.status = "";
        this.message = "There is no order";
    }
    public OrderStatus(Order ord, String stat, String msg) {
        this.order = ord;
        this.status = stat;
        this.message = msg;
    }

    // setter
    public void setOrder(Order o) {
        this.order = o;
    }
    public void setStatus(String s) {
        this.status = s;
    }
    public void setMessage(String m) {
        this.message = m;
    }

    // getter
    public Order getOrder() {
        return this.order;
    }
    public String getStatus() {
        return this.status;
    }
    public String getMessage() {
        return this.message;
    }
}
