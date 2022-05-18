package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.BiFunction;

@Getter
@AllArgsConstructor
public enum CalculatorSymbolB {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    DIVISION("/", (a, b) -> a / b),
    MULTIPLICATION("*", (a, b) -> a * b),
    UNKNOWN(null, null);

    private final String symbol;
    private final BiFunction<Double, Double, Double> calculateFunc;


    public Double calculate(Double a, Double b) {
        assert this != UNKNOWN;
        return this.calculateFunc.apply(a, b);
    }

    public static CalculatorSymbolB findSymbol(String arithmeticText) {
        return Arrays.stream(CalculatorSymbolB.values())
                .filter(type -> type.symbol != null)
                .filter(type -> arithmeticText.contains(type.symbol))
                .findFirst()
                .orElse(CalculatorSymbolB.UNKNOWN);
    }


}
