package com.example.demo.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndOrderDetailVO {

    private int orderSeq;
    private int orderDetailSeq;
    private String productTypeCode;
    private int packageSeq;
    private int salePrice;
    private String priceType;
    private int sellingPrice;
    private String discountYn;
    private int earlybirdPrice;
    private int membershipPrice;
    private int discountPrice;
    private String taxType;
    private int cnt;
    private Date registDate;
    private Date updateDate;
    private String paymentStatusCode;

    private int productSeq;
    private String productName;

    @JsonIgnore
    private int costPrice;

    private int originalPrice;

    @JsonIgnore
    private int basePrice;

    private String orderNo;
    private int paymentPrice;

    @Builder
    public YndOrderDetailVO(int orderSeq, int orderDetailSeq, String productTypeCode, int packageSeq, int salePrice, String priceType, int sellingPrice, String discountYn, int earlybirdPrice, int membershipPrice, int discountPrice, String taxType, int cnt, Date registDate, Date updateDate, String paymentStatusCode, int productSeq, String productName, int costPrice, int originalPrice, int basePrice, String orderNo, int paymentPrice) {
        this.orderSeq = orderSeq;
        this.orderDetailSeq = orderDetailSeq;
        this.productTypeCode = productTypeCode;
        this.packageSeq = packageSeq;
        this.salePrice = salePrice;
        this.priceType = priceType;
        this.sellingPrice = sellingPrice;
        this.discountYn = discountYn;
        this.earlybirdPrice = earlybirdPrice;
        this.membershipPrice = membershipPrice;
        this.discountPrice = discountPrice;
        this.taxType = taxType;
        this.cnt = cnt;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.paymentStatusCode = paymentStatusCode;
        this.productSeq = productSeq;
        this.productName = productName;
        this.costPrice = costPrice;
        this.originalPrice = originalPrice;
        this.basePrice = basePrice;
        this.orderNo = orderNo;
        this.paymentPrice = paymentPrice;
    }
}
