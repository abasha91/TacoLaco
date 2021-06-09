package com.example.demo.Service.Order;

import javax.transaction.Transactional;

import com.example.demo.Model.Order;
import com.example.demo.Repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImplementation implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    @Transactional
    public Order CreateOrder(Order order) {        
        return orderRepository.save(order);
    }

    @Override
    public double TotalPrice(Order order) {
        /*
            this block of code can be moved to the GETTER method of total in Order object, in case
            these is no need to get the total before the discount
        */

        double totalPrice = orderRepository.getTotalPrice(order.getId());

        if (orderRepository.numberOfTacosByOrder(order.getId()) >= 4)
            return totalPrice - (totalPrice * 0.20);
        
        return totalPrice;
    }

    @Override
    public Order getById(long id) {
        return orderRepository.getOne(id);
    }
}