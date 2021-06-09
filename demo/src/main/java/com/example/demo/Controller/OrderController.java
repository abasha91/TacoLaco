package com.example.demo.Controller;

import com.example.demo.Model.Order;
import com.example.demo.Service.Order.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    public Order addOrder(@RequestBody Order order){
        return orderService.CreateOrder(order);
    }
}
