package com.example.demo.test;

import com.example.demo.dto.test.Item;
import com.example.demo.dto.test.PaymentRequest;
import com.example.demo.dto.test.YndCouponParamVO;
import com.example.demo.dto.test.YndOrderDetailVO;
import com.example.demo.dto.test.YndOrderProductVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    @Getter
    @AllArgsConstructor
    public enum PaymentTypeEnum {
        CARD("CARD", "신용카드", "http://naver.com"),
        ACCOUNT("ACCOUNT", "계좌이체", ""),
        REMITTANCE("REMITTANCE", "무통장", ""),
        PHONE("PHONE", "휴대폰결제", ""),
        TOSS("TOSS", "토스", ""),
        NPAY("NPAY", "네이버페이", ""),
        PAYCO("PAYCO", "페이코", ""),
        KAKAO("KAKAO", "카카오페이", "");

        private String code;
        private String value;
        private String naver;
    }

    @Getter
    @AllArgsConstructor
    public enum PackageTypeEnum {
        CLASS("CLASS", "디지털상품"),
        REAL("REAL", "실물상품"),
        APP("APP", "앱이용권"),
        COURSE("COURSE", "코스상품"),    // 심화과정
        COMBINATION("COMBINATION", "묶음상품"),
        ENTRANCE("ENTRANCE", "입학상품");

        private String code;
        private String value;
    }


    @Test
    void enumContainTest() {
//        System.out.println(Arrays.asList(PaymentTypeEnum.PAYCO, PaymentTypeEnum.ACCOUNT, PaymentTypeEnum.CARD).contains(PaymentTypeEnum.CARD));
//        Stream.of(PaymentTypeEnum.PAYCO, PaymentTypeEnum.ACCOUNT, PaymentTypeEnum.CARD).anyMatch(paymentTypeEnum -> {
//            paymentTypeEnum.getCode().equals("CARD");
//        })

        System.out.println(Arrays.stream(PaymentTypeEnum.values()).anyMatch(
                paymentTypeEnum -> paymentTypeEnum.getCode().equals("CARD"))); // true
    }

    @Test
    void containTest() {
        String[] fruitsArray = {"apple", "banana", "kiwi", "mango"};
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList(fruitsArray));

        System.out.println("Has apple? : " + fruits.contains("apple"));
        if (fruits.contains("mango")) {
            System.out.println("There is mango in the list");
        }
        if (!fruits.contains("strawberry")) {
            System.out.println("There is no strawberry in the list");
        }
    }

    @Test
    void containTest2() {
        List<String> packageTypeList = Arrays.asList(PackageTypeEnum.CLASS.getCode(), PackageTypeEnum.REAL.getCode(), PackageTypeEnum.APP.getCode());
        if (packageTypeList.contains(PackageTypeEnum.CLASS.getCode())) {
            System.out.println("CLASS");
        }
    }

    @Test
    void updateOrderCarts() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(Item.builder().a("a").b("b").c("c").packageTypeEnum(Item.PackageTypeEnum.APP).build());
        itemList.add(Item.builder().a("aa").b("bb").c("cc").packageTypeEnum(Item.PackageTypeEnum.REAL).build());
        System.out.println(itemList);
        itemList.forEach(item -> item.setC("DDD"));
        System.out.println(itemList);
        itemList.forEach(item -> item.udpateB("BBB"));
        System.out.println(itemList);
    }

    @Test
    void forEachNullTest() {
        List<Item> itemList = new ArrayList<>();
        itemList.forEach(System.out::println);
    }

    @Test
    void addAllTest() {
        YndCouponParamVO yndCouponParamVO1 = YndCouponParamVO.builder().couponCode("couponCode1").build();
        YndCouponParamVO yndCouponParamVO2 = YndCouponParamVO.builder().couponCode("couponCode2").build();

        List<YndCouponParamVO> yndCouponParamVOList = new ArrayList<>();
        yndCouponParamVOList.add(yndCouponParamVO1);
        yndCouponParamVOList.add(yndCouponParamVO2);
        System.out.println("yndCouponParamVOList=" + yndCouponParamVOList);

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .deviceType("test")
                .couponRequests(yndCouponParamVOList)
                .build();

        List<YndCouponParamVO> yndCouponParamVOList2 = new ArrayList<>();
        if (paymentRequest.getCouponRequests() != null) {   // 쿠폰있으면
//            yndCouponParamVOList2 = paymentRequest.getCouponRequests();
            yndCouponParamVOList2.addAll(yndCouponParamVOList);
        }
        System.out.println("yndCouponParamVOList2=" + yndCouponParamVOList2);
    }

    @Getter
    @AllArgsConstructor
    public enum ProductTypeEnum {
        CLASS("CLASS", "클래스"),
        REAL("REAL", "현물"),
        APP("APP", "앱이용권"),
        RANDOM("RANDOM", "임의상품"),
        DELIVERY("DELIVERY", "배송비");

        private String code;
        private String value;
    }

    private int getTotalReal(List<YndOrderDetailVO> yndOrderDetailVOList, List<YndOrderProductVO> yndOrderProductVOList, int packageSeq) {

        int totalReal = 0;
        for (YndOrderDetailVO yndOrderDetailVO : yndOrderDetailVOList) {
            if (packageSeq == yndOrderDetailVO.getPackageSeq()) {
                for (YndOrderProductVO yndOrderProductVO : yndOrderProductVOList) {
                    if (yndOrderProductVO.getProductSeq() == yndOrderDetailVO.getProductSeq()
                            && yndOrderProductVO.getProductTypeCode().equals(ProductTypeEnum.REAL.getCode())) {
                        totalReal += yndOrderProductVO.getMembershipSalePrice();
                        yndOrderDetailVO.setPaymentPrice(yndOrderProductVO.getMembershipSalePrice());
                        yndOrderDetailVO.setDiscountYn("N");
                    }
                }
            }
        }
        return totalReal;
    }

    @Test
    @DisplayName("setPaymentPrice setDiscountYn 값 저장 되는지 확인 ")
    void getTotalRealTest() {
        List<YndOrderDetailVO> yndOrderDetailVOList = new ArrayList<>();
        yndOrderDetailVOList.add(YndOrderDetailVO.builder().packageSeq(1).productSeq(1).build());
//        yndOrderDetailVOList.add(YndOrderDetailVO.builder().packageSeq(1).productSeq(1).build());
//        yndOrderDetailVOList.add(YndOrderDetailVO.builder().packageSeq(1).productSeq(1).build());

        List<YndOrderProductVO> yndOrderProductVOList = new ArrayList<>();
        yndOrderProductVOList.add(YndOrderProductVO.builder().packageSeq(1).productSeq(1).productTypeCode(ProductTypeEnum.REAL.getCode()).membershipSalePrice(1000).build());
        yndOrderProductVOList.add(YndOrderProductVO.builder().packageSeq(1).productSeq(1).productTypeCode(ProductTypeEnum.REAL.getCode()).membershipSalePrice(2000).build());
        yndOrderProductVOList.add(YndOrderProductVO.builder().packageSeq(1).productSeq(1).productTypeCode(ProductTypeEnum.REAL.getCode()).membershipSalePrice(3000).build());

        int totalReal = getTotalReal(yndOrderDetailVOList, yndOrderProductVOList, 1);
        System.out.println(totalReal);
        System.out.println(yndOrderDetailVOList); // setPaymentPrice setDiscountYn 값 저장 되는지 확인

    }


}
