package com.example.demo.dto.test;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class Item {
    private String a;
    private String b;
    @Setter
    private String c;
    private PackageTypeEnum packageTypeEnum;

    public void udpateB(String b) {
        this.b = b;
    }

    @Builder
    public Item(String a, String b, String c, PackageTypeEnum packageTypeEnum) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.packageTypeEnum = packageTypeEnum;
    }

    @Getter
    @RequiredArgsConstructor
    public enum PackageTypeEnum {
        CLASS("CLASS", "디지털상품"),
        REAL("REAL", "실물상품"),
        APP("APP", "앱이용권"),
        COURSE("COURSE", "코스상품"),    // 심화과정
        COMBINATION("COMBINATION", "묶음상품"),
        ENTRANCE("ENTRANCE", "입학상품");
        private final String code;
        private final String value;
    }
}
