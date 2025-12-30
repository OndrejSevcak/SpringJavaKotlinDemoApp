package com.intro.services.impl.bank;

import com.intro.services.AccountProvider;
import com.intro.services.BalanceProvider;
import com.intro.services.PaymentGateway;
import org.springframework.stereotype.Component;


//@Component marks the class as Beans
//default scope is singleton
@Component
public class OnlinePayment implements PaymentGateway {

    private final AccountProvider accountProvider;
    private final BalanceProvider balanceProvider;

    public OnlinePayment(AccountProvider accountProvider, BalanceProvider balanceProvider) {
        this.accountProvider = accountProvider;
        this.balanceProvider = balanceProvider;
    }

    @Override
    public Boolean processPayment(String accountNumber, double amount) {

        if(!accountProvider.AccountExists(accountNumber)){
            //log account not exist
            return false;
        }

        double actualBalance = balanceProvider.getBalance(accountNumber);

        if(actualBalance < amount){
            //log unsufficient balance
            return false;
        }

        balanceProvider.setBalance(accountNumber, actualBalance - amount);
        return true;
    }
}
