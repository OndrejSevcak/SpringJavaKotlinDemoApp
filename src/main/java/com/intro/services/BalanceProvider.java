package com.intro.services;

public interface BalanceProvider {

    double getBalance(String accountId);
    double setBalance(String accountId, double amount);
    boolean addAccount(String accountId, double initialBalance);
    boolean removeAccount(String accountId);
}
