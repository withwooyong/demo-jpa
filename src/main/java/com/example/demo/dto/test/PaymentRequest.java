package com.example.demo.dto.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor

public class PaymentRequest {
    private String deviceType;

    private String orderNo;
    private String paymentWay;
    private String paymentType;
    private int price;

    private List<Integer> discountPrices;
    private List<Integer> detailPaymentPrices;
    private List<Integer> detailCounts;
    private List<Integer> paymentPrices;

    // 쿠폰할인정보
    private List<YndCouponParamVO> couponRequests;

    //수기결제 관련 정보
    private int cartType; //장바구니 타입(1:수기결제)
    private String midName; //무이자 12개월, 24개월
    private int cartUserSeq; //장바구니 구매 사용자

    // 배송 관련 정보들
    private DeliveryRequest deliveryRequest;

    // 회원 멤버십 여부
    private Boolean isEntrance;
    // 분할결제 여부
    private Boolean isDividePayment;

    @Builder
    public PaymentRequest(String deviceType, String orderNo, String paymentWay, String paymentType, int price, List<Integer> discountPrices, List<Integer> detailPaymentPrices, List<Integer> detailCounts, List<Integer> paymentPrices, List<YndCouponParamVO> couponRequests, int cartType, String midName, int cartUserSeq, DeliveryRequest deliveryRequest, Boolean isEntrance, Boolean isDividePayment) {
        this.deviceType = deviceType;
        this.orderNo = orderNo;
        this.paymentWay = paymentWay;
        this.paymentType = paymentType;
        this.price = price;
        this.discountPrices = discountPrices;
        this.detailPaymentPrices = detailPaymentPrices;
        this.detailCounts = detailCounts;
        this.paymentPrices = paymentPrices;
        this.couponRequests = couponRequests;
        this.cartType = cartType;
        this.midName = midName;
        this.cartUserSeq = cartUserSeq;
        this.deliveryRequest = deliveryRequest;
        this.isEntrance = isEntrance;
        this.isDividePayment = isDividePayment;
    }
}
