package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderItemValidationTest {

    @Test
    void quantityMustBeGreaterThanZero() {
        Product laptop =
                new Product(1, "Laptop", 12000);

        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(laptop, 0)
        );
    }

    @Test
    void productCannotBeNull() {
        assertThrows(IllegalArgumentException.class, 
                () -> new OrderItem(null, 1)
        );
    }
}