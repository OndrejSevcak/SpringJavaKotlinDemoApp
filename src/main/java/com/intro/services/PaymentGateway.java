package com.intro.services;

public interface PaymentGateway {
    Boolean processPayment(String accountNumber, double amount);
}
