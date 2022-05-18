package com.example.demo.enums.test;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EnumMapperValue {
    private final String code;
    private final String title;

    public EnumMapperValue(EnumMapperType enumMapperType) {
        code = enumMapperType.getCode();
        title = enumMapperType.getTitle();
    }

}
