package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum CalculatorType {

    CALC_A(value -> value),
    CALC_B(value -> value * 10),
    CALC_C(value -> value * 3),
    CALC_ETC(value -> 0L);

    private final Function<Long, Long> expression;

    public long calculate(long value) {
        return expression.apply(value);
    }
}
