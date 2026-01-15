package com.intro.controllers;

import com.intro.config.PizzaConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    private final PizzaConfig pizzaConfig;

    public PizzaController(PizzaConfig pizzaConfig) {
        this.pizzaConfig = pizzaConfig;
    }

    @GetMapping("/pizza")
    public String getPizzaGreetings() {
        return "Hello your favorite Pizza is "
                + pizzaConfig.getSize() + " size pizza with "
                + pizzaConfig.getSauce() + " sauce and "
                + pizzaConfig.getTopping() + " topping!";
    }
}
