package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Transactional
public class OrderItem {
    @Id
    @SequenceGenerator(name="identifier", sequenceName="order_item_id_serial", allocationSize=1)  
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="identifier")
    private long id;

    private int quantities;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @JsonManagedReference
    private Taco taco;

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getQuantities() {
        return this.quantities;
    }
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    @JsonBackReference
    public Order getOrder() {
        return this.order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Taco getTaco() {
        return this.taco;
    }
    public void setTaco(Taco taco) {
        this.taco = taco;
    }
}
