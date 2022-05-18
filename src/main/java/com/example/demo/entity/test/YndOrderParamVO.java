package com.example.demo.entity.test;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndOrderParamVO {
    private int price;
    private String paymentType;
    private String paymentWayCode;

    @Builder
    public YndOrderParamVO(int price, String paymentType, String paymentWayCode) {
        this.price = price;
        this.paymentType = paymentType;
        this.paymentWayCode = paymentWayCode;
    }
}
