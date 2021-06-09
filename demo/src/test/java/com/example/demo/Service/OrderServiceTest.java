package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Model.OrderItem;
import com.example.demo.Model.Taco;
import com.example.demo.Service.Order.OrderService;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment  = WebEnvironment.RANDOM_PORT)
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    private Order createOrderObject(int tacoQuantities1 ){
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
        orderItem1.setQuantities(tacoQuantities1);
        orderItem1.setTaco(taco);
        order.addOrderItem(orderItem1);

        return order;
    }

    @Test
    public void discontTest_withDiscont() throws JSONException{
        /*
            case:
                check if the disconunt method is working fine
                - quantities: more than 4 taco's
                1 Veggie  --> 2.5 * 1   = $2.5
                3 chicken --> 3 * 3     = $9
                total                   = $11.5
            expected result:
                total price = (4 taco's price) * 20%
                            = 11 - (11 * 0.2) = 9.2
        */

        Order order = this.createOrderObject(3);    
        order = orderService.CreateOrder(order);

        assertEquals(orderService.TotalPrice(order), 9.2);
    }

    @Test
    public void discontTestWithoutDiscont() throws JSONException{
        /*
            case:
                check if the disconunt method is working fine
                - quantities: more than 4 taco's
                1 Veggie  --> 2.5 * 1   = $2.5
                3 chicken --> 1 * 3     = $3
                total                   = $5.5
            expected result:
                
        */

        Order order = this.createOrderObject(1);    
        order = orderService.CreateOrder(order);

        assertEquals(orderService.TotalPrice(order), 5.5);
    }


}
