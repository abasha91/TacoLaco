package com.example.demo.Repository;

import com.example.demo.Model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {
    @Query("SELECT SUM(oi.quantities) FROM OrderItem oi where oi.order.id = :orderId")
    public int numberOfTacosByOrder( @Param("orderId") Long orderId);

    @Query("SELECT SUM(oi.taco.price*oi.quantities) FROM OrderItem oi where oi.order.id = :orderId")
    public double getTotalPrice( @Param("orderId") Long orderId);
}
