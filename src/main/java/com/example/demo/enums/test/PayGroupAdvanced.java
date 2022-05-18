package com.example.demo.enums.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public enum PayGroupAdvanced {

    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSFER, PayType.REMITTANCE, PayType.ON_SITE_PAYMENT, PayType.TOSS)),
    CARD("카드", Arrays.asList(PayType.PAYCO, PayType.CARD, PayType.KAKAO_PAY, PayType.BAEMIN_PAY)),
    ETC("기타", Arrays.asList(PayType.POINT, PayType.COUPON)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private final String title;
    private final List<PayType> payList;

    public static PayGroupAdvanced findByPayType(PayType payType) {
        return Arrays.stream(PayGroupAdvanced.values())
                .filter(payGroupAdvanced -> payGroupAdvanced.hasPayCode(payType))
                .findAny()
                .orElse(EMPTY);
    }

    public boolean hasPayCode(PayType payType) {
        return payList.stream()
                .anyMatch(pay -> pay == payType);
    }

}
