[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=24000849&assignment_repo_type=AssignmentRepo)
# Merchant-order-desk-and-catalogue-engine
## PayNest Commerce Kernel Demo
## How to Run the Demo
To compile the application and launch the interactive command-line interface demo, execute the following command in the terminal:
mvn compile
mvn test
mvn exec:java

## Expected Output
Reviewers will see a clean, human-readable receipt summary that will display the customer details, subtotal breakdowns, and an easily verifiable grand total:

================================
ORDER #1001
Customer: Zubaida Khan
Email: zubaida.khan@umuzi.org
================================
Laptop | Qty: 1 | Subtotal: R12000,00
Mouse | Qty: 2 | Subtotal: R400,00
Keyboard | Qty: 3 | Subtotal: R1500,00
--------------------------------
Grand Total: R13900.00
================================

## Running Automated Tests
To run the full JUnit 5 test suite covering validation edge cases and calculation verification:
mvn test

## Project structure
## 📁 Project Structure


```text

.

├── pom.xml

└── src

    ├── main

    │   └── java

    │       └── com

    │           └── paynestsystem

    │               ├── app

    │               │   └── PayNestApplication.java

    │               ├── domain

    │               │   ├── Customer.java

    │               │   ├── Order.java

    │               │   ├── OrderItem.java

    │               │   └── Product.java

    │               └── service

    │                   └── OrderService.java
    └── test/
        └── java/
            └── com/
                └── paynestsystem/
                    ├── domain/
                    │   ├── OrderTest.java
                    │   └── OrderItemValidationTest.java
                    └── service/
                        └── OrderServiceTest.java

                    │   ├── OrderItemValidationTest.java

## Design decisions
- Product, Customer, Order and OrderItem are implemented as domain entities.
- Validation is performed in constructors and public methods to prevent invalid products, customers, and order quantities.
- Order totals are calculated by summing orderItem subtotals, ensuring consistent total calculations.
- Order items are exposed through an unmodifiable list to protect internal state from external modification.
- Monetary values use double arithmetic because this aligns with the capstone specification.
- In a production payment system, BigDecimal would be preferred for currency calculations to avoid floating-point precision issues.
- The design can be extended later with persistence, payment integrations, or API endpoints without changing the core domain model.
