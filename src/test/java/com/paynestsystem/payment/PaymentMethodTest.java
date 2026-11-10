package com.paynestsystem.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentMethodTest {
    @Test
    void checkoutCanUseDifferentPaymentMethods() {
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();
        PaymentMethod eft = new EftPayment();

        assertTrue(card.processPayment(13900));
        assertTrue(wallet.processPayment(13900));
        assertTrue(eft.processPayment(13900));

        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
        assertEquals("EFT", eft.getPaymentType());
    }
}
