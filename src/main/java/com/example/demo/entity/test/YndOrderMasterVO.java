package com.example.demo.entity.test;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndOrderMasterVO {
    // OrderMaster
    private int orderSeq;
    private int packageSeq;
    private String orderName;   // packageName
    private int userSeq;
    private int discountPrice;

    @Builder
    public YndOrderMasterVO(int orderSeq, int packageSeq, String orderName, int userSeq, int discountPrice) {
        this.orderSeq = orderSeq;
        this.packageSeq = packageSeq;
        this.orderName = orderName;
        this.userSeq = userSeq;
        this.discountPrice = discountPrice;
    }
}