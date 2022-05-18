package com.example.demo.test;

import com.example.demo.entity.test.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
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


}
