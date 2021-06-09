package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Formula;

@Entity(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="order_id_serial", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    private long id;

    /*
        there more than one way to write this code:
        1. move this query to the Repositoty and call it on the Service layer if needed;
           - this case should be used if we need to save the total price for each order
             into the DB
        2. or use the @Formula
           - in case these is no need to save the total value in the DB
    */
    @Formula(value = "(SELECT coalesce(sum(oi.quantities),0) from order_item oi where oi.order_id = id)")
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return this.total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @JsonManagedReference
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }
    private void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /*
    this is a "helper" method; which is allow adding a new item to the order via
    the Order object
    */ 
    public void addOrderItem(OrderItem item){
        orderItems.add(item);
        setOrderItems(orderItems);
        item.setOrder(this);
    }
}
