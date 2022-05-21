package com.example.demo.dto.test;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndOrderProductVO {
    //PackageToProduct
    private int packageSeq;
    private int productSeq; //상품번호
    private int salePrice;
    private int membershipSalePrice;
    private int earlyBirdSalePrice;
    private int couponDiscountPrice;
    private String taxType; // 과세구분
    private int sortOrder;
    private String requiredYn;

    private String versionCode;
    private int originalPackageSeq;
    private int originalSalePrice;

    //Product
    private String title; //상품명
    private String productTypeCode; //상품구분(여기서는 CLASS/REAL/APP)

    private String accountingCalcTypeName;
    private String useYn;
    private Integer costPrice; // 원가
    private Integer originalPrice; // 정가
    private Integer basePrice; // 기준판매가 (이가격 밑으로는 판매가 안됨)
    private String appOption; // 앱이용권 구분(프리미엄/골드)

    @Builder
    public YndOrderProductVO(int packageSeq, int productSeq, int salePrice, int membershipSalePrice, int earlyBirdSalePrice, int couponDiscountPrice, String taxType, int sortOrder, String requiredYn, String versionCode, int originalPackageSeq, int originalSalePrice, String title, String productTypeCode, String accountingCalcTypeName, String useYn, Integer costPrice, Integer originalPrice, Integer basePrice, String appOption) {
        this.packageSeq = packageSeq;
        this.productSeq = productSeq;
        this.salePrice = salePrice;
        this.membershipSalePrice = membershipSalePrice;
        this.earlyBirdSalePrice = earlyBirdSalePrice;
        this.couponDiscountPrice = couponDiscountPrice;
        this.taxType = taxType;
        this.sortOrder = sortOrder;
        this.requiredYn = requiredYn;
        this.versionCode = versionCode;
        this.originalPackageSeq = originalPackageSeq;
        this.originalSalePrice = originalSalePrice;
        this.title = title;
        this.productTypeCode = productTypeCode;
        this.accountingCalcTypeName = accountingCalcTypeName;
        this.useYn = useYn;
        this.costPrice = costPrice;
        this.originalPrice = originalPrice;
        this.basePrice = basePrice;
        this.appOption = appOption;
    }
}
