# TacoLoco

This is a solution for food truck orders via Mobile App or any REST API calls, I created this project using Spring-Boot & Hibernate, and Postgresql for the DB.

Instructions:
1. install Postgresql
2. create a new DB ("tacoloco" is the name used on the application)
3. update the values on "application.properties" for datasource variables
  defualt values:
  spring.datasource.url = jdbc:postgresql://localhost:5432/tacoloco
  spring.datasource.username = postgres
  spring.datasource.password = postgres

4. run the application for the first time
5. run the following queries on the database before you run any Test:
  CREATE SEQUENCE order_item_id_serial;
  CREATE SEQUENCE order_id_serial;
  insert into customer values (1, 'anas')
  insert into taco values (1, 2.5, 'Veggie Taco'), (2, 3, 'Chicken Taco'),(3, 3, 'Beef Taco'),(4, 3.5, 'Chorizo Taco')
  
6. execute the test cases
  Test case 1:
    Post new order: 
      the expected result is to save a new order into the database; includes: 1 Order, and 2 OrderItems
  Test case 2:
    Order with Discount:
      Order two types of taco's; 4 taco's in total
  Test case 3:
     Order without Discount:
      Order two types of taco's; 2 taco's in total
 
