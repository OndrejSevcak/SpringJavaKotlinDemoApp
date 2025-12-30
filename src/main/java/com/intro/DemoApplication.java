package com.intro;

import com.intro.services.AccountProvider;
import com.intro.services.BalanceProvider;
import com.intro.services.ColourPrinter;
import com.intro.services.PaymentGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import com.intro.kotlin.Utility;

//@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.config"})
@SpringBootApplication
public class DemoApplication {

    private final ColourPrinter printerService;
    private final PaymentGateway paymentGateway;
    private final AccountProvider accountProvider;
    private final BalanceProvider balanceProvider;

    public DemoApplication(ColourPrinter printerService, PaymentGateway paymentGateway, AccountProvider accountProvider, BalanceProvider balanceProvider) {
        this.printerService = printerService;
        this.paymentGateway = paymentGateway;
        this.accountProvider = accountProvider;
        this.balanceProvider = balanceProvider;
    }

    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            System.out.println("Lets inspect the beans provided by spring framework");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames){
                System.out.println(beanName);
            }

            //kotlin to java interop
            int numberFromKotlin = Utility.Companion.getNumber();
            System.out.println("A number from KOTLIN class: " + numberFromKotlin);

            //getting a bean instance from dependency injection
            System.out.println("ColourPrinter output: " + printerService.printColour());

            //testing @ComponentScan
            String accountId = "acc001";
            boolean accountCreated = accountProvider.AddAccount(accountId, 500.0);
            System.out.println("Account " + accountId + " created: " + accountCreated);
            double paymentAmount = 150.0;
            boolean paymentProcessed = paymentGateway.processPayment(accountId, paymentAmount);
            System.out.println("Payment of " + paymentAmount + " processed for account " + accountId + ": " + paymentProcessed);
            System.out.println("Remaining balance: " + balanceProvider.getBalance(accountId));

        };
    }


}
