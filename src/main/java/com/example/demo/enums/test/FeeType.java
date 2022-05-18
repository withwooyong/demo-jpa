package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeeType implements EnumMapperType {

    PERCENT("정율"),
    MONEY("정액");


    private final String title;

    @Override
    public String getCode() {
        return name();
    }
}
