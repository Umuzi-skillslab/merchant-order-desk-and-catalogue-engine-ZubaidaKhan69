package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
 
    @Test
    void calculateTotalReturnsGrandTotal() {
        
        Customer customer = new Customer(1, "Zubaida Khan", "zubaida.khan@umuzi.org");
        
        Order order = new Order(1001, customer);
        
        Product laptop =
                new Product(1, "Laptop", 12000);
        
        Product mouse =
                new Product(2, "Mouse", 200);

        Product keyboard = 
                new Product(3, "Keyboard", 500);
 
        order.addItem(laptop, 1);
        order.addItem(mouse, 2);
        order.addItem(keyboard, 3);

        assertEquals(13900, order.calculateTotal());
    }

    @Test
    void emptyOrderReturnsZeroTotal() {
        Customer customer = new Customer(1, "Test User", "test@email.com");

        Order order = new Order(1001, customer);
        assertEquals(0.0, order.calculateTotal());
    }

    @Test
    void getItemsReturnsUnmodifiableList() {

        Customer customer = new Customer(1, "Test User", "test@email.com");

        Order order = new Order(1001, customer);

        assertThrows(UnsupportedOperationException.class, () -> {
            order.getItems().add(null);
        });
    
    }
    @Test
    void shouldRejectNullCustomer() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Order(1, null);
        });
    }
}