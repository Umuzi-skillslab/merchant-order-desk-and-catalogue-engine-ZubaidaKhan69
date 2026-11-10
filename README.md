# PayNest Commerce & Unified Checkout System

## PayNest Commerce Kernel Demo

## Overview

This project was developed for the PayNest Capstone Project and combines the requirements of:

- Capstone 1: Merchant Order Desk and Catalogue Engine
- Capstone 3: Unified Checkout Across Payment Rails

The application provides a lightweight commerce system for small merchants to manage products, customers, and orders while supporting a unified checkout process through multiple payment methods.

The solution is built using Java 21, Apache Maven, and JUnit 5, applying object-oriented programming principles such as encapsulation, composition, abstraction, and polymorphism.

---

## How to Run the Demo

Compile the project:

```bash
mvn compile
```

Run the automated tests:

```bash
mvn test
```

Launch the application:

```bash
mvn exec:java
```

---

## Expected Output

Reviewers will see a clean, human-readable order summary followed by payment processing and checkout confirmation.

```text
================================
ORDER #1001
Customer: Zubaida Khan
Email: zubaida.khan@umuzi.org
================================
Laptop | Qty: 1 | Subtotal: R12000.00
Mouse | Qty: 2 | Subtotal: R400.00
Keyboard | Qty: 3 | Subtotal: R1500.00
--------------------------------
Grand Total: R13900.00
================================

Processing card payment for R13900.00
Payment successful via CARD
Amount: R13900.00
Order #1001 has been successfully processed.
```

---

## Running Automated Tests

Run the complete JUnit 5 test suite:

```bash
mvn test
```

Expected result:

```text
BUILD SUCCESS
```

---

## Features

### Product Catalogue

Products can be created with:

- Product ID
- Product Name
- Product Price (Rand)

Example:

```java
Product laptop = new Product(1, "Laptop", 12000);
```

### Customer Management

Customers store:

- Customer ID
- Customer Name
- Email Address

Example:

```java
Customer customer =
        new Customer(
                1,
                "Zubaida Khan",
                "zubaida.khan@umuzi.org"
        );
```

### Order Management

Orders support:

- Multiple products
- Product quantities
- Line-item subtotals
- Grand total calculations

Example:

```java
Order order = new Order(1001, customer);

order.addItem(laptop, 1);
order.addItem(mouse, 2);
order.addItem(keyboard, 3);
```

### Order Summary

The application generates a detailed order summary showing:

- Customer information
- Products ordered
- Quantities purchased
- Line-item subtotals
- Grand total

---

## Unified Checkout System

### PaymentMethod Interface

The checkout system is built around a common payment contract:

```java
public interface PaymentMethod {
    boolean processPayment(double amount);
    String getPaymentType();
}
```

This allows checkout functionality to work with any supported payment method.

### Supported Payment Methods

The application currently supports:

- Card Payment
- EFT Payment
- Wallet Payment

These payment methods implement the `PaymentMethod` interface and can be used interchangeably during checkout.

### Checkout Process

The checkout flow:

1. Calculates the order total.
2. Passes the total to a selected payment method.
3. Processes the payment through `PaymentProcessor`.
4. Prints a payment confirmation message.

Example:

```java
PaymentMethod paymentMethod = new CardPayment();
order.checkout(paymentMethod);
```

---

## Design Decision

The checkout process uses the `PaymentMethod` interface instead of hard-coded conditional statements.

Rather than using large `if`, `else`, or `switch` statements for each payment rail, the application relies on polymorphism. Each payment type implements the same contract and manages its own payment behaviour.

This approach:

- Reduces code duplication
- Improves maintainability
- Encourages loose coupling
- Makes the system easy to extend

For example, a future payment option such as:

```java
BuyNowPayLaterPayment
```

can be added by creating a new class that implements `PaymentMethod` without modifying existing checkout or order calculation logic.

This follows the Open/Closed Principle by allowing the system to be extended without changing existing functionality.

---

## Project Structure

```text
├── pom.xml
│
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── paynestsystem
    │               ├── app
    │               │   └── PayNestApplication.java
    │               │
    │               ├── domain
    │               │   ├── Customer.java
    │               │   ├── Product.java
    │               │   ├── Order.java
    │               │   └── OrderItem.java
    │               │
    │               ├── payment
    │               │   ├── PaymentMethod.java
    │               │   ├── CardPayment.java
    │               │   ├── EftPayment.java
    │               │   ├── WalletPayment.java
    │               │   └── PaymentProcessor.java
    │               │
    │               └── service
    │                   └── OrderService.java
    │
    └── test
        └── java
            └── com
                └── paynestsystem
                    ├── domain
                    │   ├── OrderTest.java
                    │   └── OrderItemValidationTest.java
                    │
                    ├── payment
                    │   └── PaymentMethodTest.java
                    │
                    └── service
                        └── OrderServiceTest.java
```

---

## Testing

The project includes JUnit 5 tests covering:

### Domain Tests

- Order total calculation
- Empty order scenarios
- Order validation
- Collection encapsulation
- Order item validation

### Payment Tests

- Card payment processing
- Wallet payment processing
- Payment type verification

### Service Tests

- Order creation workflow
- Product addition workflow
- Total calculation workflow

---

## Design Principles Applied

### Encapsulation

All domain fields are private and accessed through getter methods.

### Composition

An `Order` owns and manages multiple `OrderItem` objects.

### Abstraction

Checkout functionality depends on the `PaymentMethod` interface rather than concrete payment implementations.

### Polymorphism

Different payment methods can be used through the same checkout flow without changing business logic.

### Open/Closed Principle

New payment methods can be added without modifying existing checkout functionality.

---

## Technologies Used

- Java 21
- Apache Maven
- JUnit 5

---

## Author

**Zubaida Khan**  
IMI Trainee Java Developer

---


✅ Extensible Checkout Architecture

✅ Ready for Submission
