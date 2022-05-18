package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

@Getter
@AllArgsConstructor
public enum ApiEnum {

    API_A(value -> value),
    API_B(value -> value);

    //    private final String code;
    private final Function<String, String> apiA;

    public String make(String value) {
        System.out.println("ApiEnum " + value);
        return apiA.apply(value);
    }
}
