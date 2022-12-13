package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PackageTypeEnum {
    CLASS("CLASS", "디지털상품"),
    REAL("REAL", "실물상품"),
    APP("APP", "앱이용권"),
    COURSE("COURSE", "코스상품"),    // 심화과정
    COMBINATION("COMBINATION", "묶음상품"),
    ENTRANCE("ENTRANCE", "입학상품"),
    UNKNOWN("", "");

    private String code;
    private String value;

    private static final Map<String, PackageTypeEnum> enums =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(PackageTypeEnum::getCode, Function.identity())));

    public static PackageTypeEnum find(String code) {
        return Optional.ofNullable(enums.get(code)).orElse(UNKNOWN);
    }
}
