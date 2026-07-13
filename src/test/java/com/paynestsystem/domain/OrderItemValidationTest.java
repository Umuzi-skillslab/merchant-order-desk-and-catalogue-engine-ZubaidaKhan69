package com.paynestsystem.domain;

import com.paynestsystem.domain.Product;
import com.paynestsystem.domain.OrderItem; 
import org.junit.jupiter.api.Test;
 
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemValidationTest {
 
    @Test
    void quantityMustBeGreaterThanZero() {
 
        Product laptop =
                new Product(1, "Laptop", 12000);
 
        Product mouse =
                new Product(2, "Mouse", 200);

        Product keyboard = 
                new Product(3, "Keyboard", 500);
 
        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(laptop, 0)
        );
    }
}