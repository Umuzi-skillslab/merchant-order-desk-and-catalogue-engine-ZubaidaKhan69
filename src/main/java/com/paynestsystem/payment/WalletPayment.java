package com.paynestsystem.payment;

public class WalletPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Processing wallet payment for R%.2f%n", amount);
        return true; // Return true if payment is successful, false otherwise
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
    
}
