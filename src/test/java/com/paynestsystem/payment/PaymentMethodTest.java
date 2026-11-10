package com.paynestsystem.payment;

import org.junit.jupiter.api.Test;
import com.paynestsystem.payment.CardPayment;
import com.paynestsystem.payment.PaymentMethod;
import com.paynestsystem.payment.WalletPayment;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentMethodTest {
    @Test
    void checkoutCanUseDifferentPaymentMethods() {
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();

        assertTrue(card.processPayment(13900));
        assertTrue(wallet.processPayment(13900));
        
        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
    }
}
