package com.example.demo.entity.test;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndCouponParamVO {
    private int couponSeq;
    private int userSeq;
    private int packageSeq;
    private String couponCode;
    private String userId;
    private String userName;
    private int discountPrice;

    @Builder
    public YndCouponParamVO(int couponSeq, int userSeq, int packageSeq, String couponCode, String userId, String userName, int discountPrice) {
        this.couponSeq = couponSeq;
        this.userSeq = userSeq;
        this.packageSeq = packageSeq;
        this.couponCode = couponCode;
        this.userId = userId;
        this.userName = userName;
        this.discountPrice = discountPrice;
    }
}
