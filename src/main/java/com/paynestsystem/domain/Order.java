package com.paynestsystem.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private final int id;
    private final Customer customer;
    private final List<OrderItem> items;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        items.add(new OrderItem(product, quantity));
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.calculateTotal();
        }
        return total;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void printSummary() {
        System.out.println("================================");
        System.out.println("ORDER #" + id);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("================================");

        for (OrderItem item : items) {

            double subtotal = item.calculateTotal();

            System.out.printf(
                "%s | Qty: %d | Subtotal: R%.2f%n",
                item.getProduct().getName(),
                item.getQuantity(),
                subtotal
            );
        }

        System.out.println("--------------------------------");
        System.out.printf("Grand Total: R%.2f%n", calculateTotal());
        System.out.println("================================");
    }
}