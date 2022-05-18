package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum PayGroup {

    CASH("현금", Arrays.asList("ACCOUNT_TRANSFER", "REMITTANCE", "ON_SITE_PAYMENT", "TOSS")),
    CARD("카드", Arrays.asList("PAYCO", "CARD", "KAKAO_PAY", "BAEMIN_PAY")),
    ETC("기타", Arrays.asList("POINT", "COUPON")),
    EMPTY("없음", Collections.EMPTY_LIST);

    private final String title;
    private final List<String> payList;

    public static PayGroup findByPayCode(String code) {
        return Arrays.stream(PayGroup.values())
                .filter(payGroup -> payGroup.hasPayCode(code))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(String code) {
        return payList.stream()
                .anyMatch(pay -> pay.equals(code));
    }
}
