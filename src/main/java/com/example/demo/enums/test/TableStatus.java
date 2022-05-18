package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TableStatus {
    Y("1", true),
    N("0", false);

    private final String key;
    private final boolean value;
}
