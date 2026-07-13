package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.domain.OrderItem;

public class PayNestApplication {

    public static void main(String[] args) {
        Product laptop = new Product(1, "Laptop", 12000);
        Product mouse = new Product(2, "Mouse", 200);
        Product keyboard = new Product(3, "Keyboard", 500);

        Customer customer = new Customer(1, "Zubaida Khan", "zubaida.khan@umuzi.org");

        Order order = new Order(1001, customer);

        order.addItem(laptop, 1);
        order.addItem(mouse, 2);
        order.addItem(keyboard, 3);

        order.printSummary();
    }
}
