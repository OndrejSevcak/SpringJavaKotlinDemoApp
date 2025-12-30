package com.intro.services;

public interface AccountProvider {

    boolean AccountExists(String accountId);
    boolean AddAccount(String accountId);
    boolean AddAccount(String accountId, Double initialBalance);
    boolean RemoveAccount(String accountId);
}
