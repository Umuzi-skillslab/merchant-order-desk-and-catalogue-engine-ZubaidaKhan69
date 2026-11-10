package com.paynestsystem.payment;

public class EftPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing EFT payment for R%.2f%n", amount);
        return true; // Return true if payment is successful, false otherwise
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
    
}
