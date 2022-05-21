package com.example.demo.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartItem {
    private int cartSeq;
    private String cartType;
    private Integer userSeq;
    private Integer packageSeq;
    private Integer productSeq;
    private String saleTypeCode;
    private String packageTypeCode;
    private String freeYn;
    private String packageName;
    private Integer originalPrice;
    private Integer salePrice;
    private Integer discountPrice;
    private Integer earlyBirdSalePrice = 0;
    private Integer membershipSalePrice = 0;
    private Integer cnt;
    private String requiredYn;
    private String checkedYn;
    private String taxType;
    private Integer sortOrder;
    private LocalDateTime registDate;
    private LocalDateTime updateDate;
    @JsonIgnore
    private String orderNo;

    @Builder
    public CartItem(int cartSeq, String cartType, Integer userSeq, Integer packageSeq, Integer productSeq, String saleTypeCode, String packageTypeCode, String freeYn, String packageName, Integer originalPrice, Integer salePrice, Integer discountPrice, Integer earlyBirdSalePrice, Integer membershipSalePrice, Integer cnt, String requiredYn, String checkedYn, String taxType, Integer sortOrder, LocalDateTime registDate, LocalDateTime updateDate, String orderNo) {
        this.cartSeq = cartSeq;
        this.cartType = cartType;
        this.userSeq = userSeq;
        this.packageSeq = packageSeq;
        this.productSeq = productSeq;
        this.saleTypeCode = saleTypeCode;
        this.packageTypeCode = packageTypeCode;
        this.freeYn = freeYn;
        this.packageName = packageName;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.discountPrice = discountPrice;
        this.earlyBirdSalePrice = earlyBirdSalePrice;
        this.membershipSalePrice = membershipSalePrice;
        this.cnt = cnt;
        this.requiredYn = requiredYn;
        this.checkedYn = checkedYn;
        this.taxType = taxType;
        this.sortOrder = sortOrder;
        this.registDate = registDate;
        this.updateDate = updateDate;
        this.orderNo = orderNo;
    }

    // 함수 이전 public static CartItem toCartItem(OrderItemRequest orderItemRequest, int userSeq) {
    public CartItem(OrderItemRequest orderItemRequest, int userSeq) {
        this.cartSeq = orderItemRequest.getCartSeq();
        this.cartType = orderItemRequest.getCartType();
        this.packageTypeCode = orderItemRequest.getPackageTypeCode();
        this.packageSeq = orderItemRequest.getPackageSeq();
        this.packageName = orderItemRequest.getPackageName();
        this.freeYn = orderItemRequest.getFreeYn();
        this.originalPrice = orderItemRequest.getOriginalPrice();
        this.salePrice = orderItemRequest.getSalePrice();
        this.cnt = orderItemRequest.getCnt();
        this.requiredYn = orderItemRequest.getRequiredYn();
        this.checkedYn = "Y"; // OrderItemRequest에는 구매 체크한 상품만 넘어오기 때문에 항상 Y
        this.productSeq = orderItemRequest.getProductSeq() == null ? 0 : orderItemRequest.getProductSeq();
        this.sortOrder = orderItemRequest.getSortOrder();
        this.userSeq = userSeq;
    }

}
