package com.paynestsystem.service;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;
 
public class OrderServiceTest {
 
    @Test
    void testOrderServiceWorkflow() {
        OrderService orderService = new OrderService();

        Customer customer = new Customer(1, "Zubaida Khan", "zubaida.khan@umuzi.org");
         
        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);
        Product keyboard = new Product(3, "Keyboard", 500);
 
        Order order = orderService.createOrder(1001, customer);
        assertNotNull(order, "Order should be created successfully");

        orderService.addProductsToOrder(order, laptop, 1);
        orderService.addProductsToOrder(order, mouse, 2);
        orderService.addProductsToOrder(order, keyboard, 3);

        order.printSummary();

        double total = orderService.calculateTotals(order);
        assertEquals(13900, total, "Total should be calculated correctly");

    }
}