package com.intro.services.impl.printer;

import com.intro.services.BluePrinter;
import com.intro.services.ColourPrinter;
import com.intro.services.RedPrinter;


public class ColourPrinterService implements ColourPrinter {

    private final BluePrinter bluePrinter;
    private final RedPrinter redPrinter;

    //using DI and configured Beans
    public ColourPrinterService(BluePrinter bluePrinter, RedPrinter redPrinter){
        this.bluePrinter = bluePrinter;
        this.redPrinter = redPrinter;
    }

    @Override
    public String printColour() {
        return String.join(",", bluePrinter.print(), redPrinter.print());
    }
}
