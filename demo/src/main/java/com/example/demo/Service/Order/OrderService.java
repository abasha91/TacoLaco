package com.example.demo.Service.Order;

import com.example.demo.Model.Order;

public interface OrderService {
    public Order CreateOrder(Order order);
    public double TotalPrice(Order order);
    public Order getById(long id);
}