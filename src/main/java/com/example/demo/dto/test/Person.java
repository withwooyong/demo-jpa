package com.example.demo.dto.test;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
    private String name;
    private int age;

    @Builder
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
