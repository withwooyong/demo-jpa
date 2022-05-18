package com.example.demo.enums.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

class EnumMapperValueTest {

    @Test
    void getNoBeanCategories() {
        System.out.println(
                Arrays.stream(FeeType.values())
                        .map(EnumMapperValue::new)
                        .collect(Collectors.toList()));
    }

}