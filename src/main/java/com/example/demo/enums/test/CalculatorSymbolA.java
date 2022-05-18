package com.example.demo.enums.test;

import java.util.Arrays;

public enum CalculatorSymbolA {
    PLUS("+"),
    MINUS("-"),
    DIVISION("/"),
    MULTIPLICATION("*"),
    UNKNOWN(null);

    private final String symbol;

    CalculatorSymbolA(String symbol) {
        this.symbol = symbol;
    }

    public static CalculatorSymbolA findSymbol(String arithmeticText) {
        return Arrays.stream(CalculatorSymbolA.values())
                .filter(type -> type.symbol != null)
                .filter(type -> arithmeticText.contains(type.symbol))
                .findFirst()
                .orElse(CalculatorSymbolA.UNKNOWN);
    }
}
