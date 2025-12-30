package com.intro.services.impl.bank;

import com.intro.services.AccountProvider;
import com.intro.services.BalanceProvider;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class AccountService implements AccountProvider {

    private List<String> accounts;
    private final BalanceProvider balanceProvider;

    public AccountService(BalanceProvider balanceProvider) {
        this.balanceProvider = balanceProvider;
        this.accounts = new java.util.ArrayList<>();
    }

    @Override
    public boolean AccountExists(String accountId) {
        return accounts.contains(accountId);
    }

    @Override
    public boolean AddAccount(String accountId) {
        if (accounts.contains(accountId)) {;
            return false;
        }
        accounts.add(accountId);
        balanceProvider.addAccount(accountId, 0.0);
        return true;
    }

    @Override
    public boolean AddAccount(String accountId, Double initialBalance) {
        if (accounts.contains(accountId)) {;
            return false;
        }
        accounts.add(accountId);
        balanceProvider.addAccount(accountId, initialBalance);
        return true;
    }

    @Override
    public boolean RemoveAccount(String accountId) {
        if (!accounts.contains(accountId)) {;
            return false;
        }
        accounts.remove(accountId);
        balanceProvider.removeAccount(accountId);
        return true;
    }
}
