package com.example.demo.test;

import com.example.demo.enums.test.EnumMapperValue;
import com.example.demo.enums.test.FeeType;
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