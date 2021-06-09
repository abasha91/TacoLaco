package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Taco {
    @Id
    @GeneratedValue
    private long id;
    private String type;
    private float price;

    @OneToOne(mappedBy = "taco")
    @JsonBackReference
    private OrderItem orderItem;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return this.price;
    }
}
