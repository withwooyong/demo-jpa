package com.example.demo.entity.test;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Student {
    private final String name;
    private final int mathScore;
    private final int englishScore;

    @Builder
    public Student(String name, int mathScore, int englishScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    public String test(String name) {
        return "test" + name;
    }
}

