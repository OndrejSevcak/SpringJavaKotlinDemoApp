package com.intro.services.impl.bank;

import com.intro.services.AccountProvider;
import com.intro.services.BalanceProvider;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class BalanceService implements BalanceProvider {

    private final HashMap<String, Double> balances = new HashMap<>();

    @Override
    public double getBalance(String accountId) {
        if(!balances.containsKey(accountId)){
            return -1;
        }
        return balances.get(accountId);
    }

    @Override
    public double setBalance(String accountId, double amount) {
        if(!balances.containsKey(accountId)){
            return -1;
        }
        return balances.put(accountId, amount);
    }

    @Override
    public boolean addAccount(String accountId, double initialBalance) {
        if(balances.containsKey(accountId)){
            //already exists
            return false;
        }
        balances.put(accountId, initialBalance);
        return true;
    }

    @Override
    public boolean removeAccount(String accountId) {
        if(!balances.containsKey(accountId)){
            //does not exist
            return false;
        }
        balances.remove(accountId);
        return true;
    }
}
