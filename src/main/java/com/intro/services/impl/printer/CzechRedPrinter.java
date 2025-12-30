package com.intro.services.impl.printer;

import com.intro.services.RedPrinter;

public class CzechRedPrinter implements RedPrinter {
    @Override
    public String print() {
        return "cervena";
    }
}
