[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=24000849&assignment_repo_type=AssignmentRepo)
# Merchant-order-desk-and-catalogue-engine
## PayNest Commerce Kernel Demo
## How to Run the Demo
To compile the application and launch the interactive command-line interface demo, execute the following command in the terminal:
mvn exec:java

## Expected Output
Reviewers will see a clean, human-readable receipt summary that will display the customer details, subtotal breakdowns, and an easily verifiable grand total:

================================
ORDER#1001
Customer: Zubaida Khan
Email: zubaida.khan@umuzi.org
================================
Laptop | Qty: 1 | Subtotal: R12000,00
Mouse | Qty: 2 | Subtotal: R400,00
Keyboard | Qty: 3 | Subtotal: R1500,00
--------------------------------
Grand Total: R13900,00
================================

## Running Automated Tests
To run the full JUnit 5 test suite covering validation edge cases and calculation verification:
mvn test

## Project structure
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── paynestsystem/
    │               ├── app/
    │               │   └── PayNestApplication.java
    │               ├── domain/
    │               │   ├── Customer.java
    │               │   ├── Order.java
    │               │   ├── OrderItem.java
    │               │   └── Product.java
    │               └── service/
    │                   └── OrderService.java
    └── test/
        └── java/
            └── com/
                └── paynestsystem/
                    ├── domain/
                    │   ├── OrderItemTest.java
                    │   └── OrderItemValidationTest.java
                    └── service/
                        └── OrderServiceTest.java

