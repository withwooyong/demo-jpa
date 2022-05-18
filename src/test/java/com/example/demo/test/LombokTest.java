package com.example.demo.test;

import com.example.demo.entity.test.Child;
import org.junit.jupiter.api.Test;

public class LombokTest {

    @Test
    void extendsTest() {
        Child child = Child.builder()
                .c("c")
                .d("d")
                .build();

        System.out.println(child);
    }
}
