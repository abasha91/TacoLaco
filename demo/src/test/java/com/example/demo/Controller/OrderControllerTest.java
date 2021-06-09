package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Model.OrderItem;
import com.example.demo.Model.Taco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {
    
    @Autowired
    TestRestTemplate testRestTemplate;
    
    private Order createOrderObject(){
        // assume that customer (id) = 1 is logged-in
        Customer customer = new Customer();
        customer.setId(1);        
        customer.setName("anas");

        Order order = new Order();
        order.setCustomer(customer);

        Taco v_taco = new Taco();

        v_taco.setId(1);
        v_taco.setType("Veggie Taco");
        v_taco.setPrice(2.5F);

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantities(1);
        orderItem.setTaco(v_taco);
        order.addOrderItem(orderItem);

        Taco taco = new Taco();
        taco.setId(2);
        taco.setType("Chicken Taco");
        taco.setPrice(3.0F);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setQuantities(3);
        orderItem1.setTaco(taco);
        order.addOrderItem(orderItem1);

        return order;
    }

    @Test
    public void postOrderTest(){
        /*
            case: 
                post order for two types of Taco's
            expected Result:
                - add 1 new row the orders table
                - add 2 rows to the order_item table
        */

        Order order = this.createOrderObject();    
        ResponseEntity<Object> response = testRestTemplate.postForEntity("/order/add", order, Object.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
}
