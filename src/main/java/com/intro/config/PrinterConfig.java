package com.intro.config;

import com.intro.services.BluePrinter;
import com.intro.services.ColourPrinter;
import com.intro.services.RedPrinter;
import com.intro.services.impl.printer.ColourPrinterService;
import com.intro.services.impl.printer.CzechBluePrinter;
import com.intro.services.impl.printer.EnglishBluePrinter;
import com.intro.services.impl.printer.EnglishRedPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrinterConfig {

    @Bean
    @Primary
    public BluePrinter bluePrinter() {
        return new EnglishBluePrinter();
    }

    @Bean
    public BluePrinter czechBluePrinter() {
        return new CzechBluePrinter();
    }

    @Bean
    public RedPrinter redPrinter() {
        return new EnglishRedPrinter();
    }

    @Bean
    public ColourPrinter colourPrinter(BluePrinter bluePrinter, RedPrinter redPrinter) {
        return new ColourPrinterService(bluePrinter, redPrinter);
    }

    //Beans are implicitly singleton scoped
    //there are two different beans of type BluePrinter
    //when injecting BluePrinter, you need to use @Qualifier to specify which one
}
