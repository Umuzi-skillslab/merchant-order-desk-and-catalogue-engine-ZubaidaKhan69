package com.paynestsystem.payment;

public class PaymentProcessor {
    public boolean processPayment(PaymentMethod paymentMethod, double amount) {
        boolean success = paymentMethod.processPayment(amount);
        if (success) {
            System.out.println("Payment successful via " + paymentMethod.getPaymentType());
            System.out.printf("Amount: R%.2f%n", amount);
        }
        else {
            System.out.println("Payment failed via " + paymentMethod.getPaymentType());
        }
        return success;
    }    
}
