package com.example.demo.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public List<Order> getOrders() {
        return this.orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
