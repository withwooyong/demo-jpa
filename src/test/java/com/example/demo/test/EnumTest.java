package com.example.demo.test;

import com.example.demo.enums.test.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EnumTest {

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

        private final String code;
        private final String value;
        private final String naver;
    }

    @Test
    void enumNullTest() {
//        var result = PaymentTypeEnum.valueOf("CARD1").getNaver();
        System.out.println(Arrays.stream(PaymentTypeEnum.values()).collect(Collectors.toList()).contains("CARD"));
//        System.out.println(result);
        PaymentTypeEnum check = PaymentTypeEnum.ACCOUNT;
        boolean checkTrue = Arrays.asList(PaymentTypeEnum.CARD, PaymentTypeEnum.ACCOUNT, PaymentTypeEnum.REMITTANCE)
                .contains(check);
        System.out.println(checkTrue);

        System.out.println(PaymentTypeEnum.valueOf("CARD").getValue());
    }

    @Test
    void rangeTest() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }

        IntStream.range(0, 10).forEach(
                System.out::println);
    }

    public static void main(String[] args) {
        System.out.println(PaymentTypeEnum.valueOf("CARD").getNaver());
        String message = "a,b:c";
        System.out.println(message);
        message = message.replace(",", "&");
        System.out.println(message);

        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                System.out.println("if " + i);
                continue;
            }
            System.out.println(i);
        }
    }

    @Test
    void mapGetTest() {
        Map<String, Object> reqParam = new HashMap<>();
        reqParam.put("type", "PartialRefund");
        reqParam.put("paymethod", "Vacct");     //가상계좌
        StringBuilder builder = new StringBuilder();
        builder.append(reqParam.get("type"));
        builder.append(reqParam.get("paymethod"));
        System.out.println(builder.toString());
    }

    @Test
    void keyValueTest() {
        TableStatus tableStatus = TableStatus.N;


        String key = tableStatus.getKey();
        boolean value = tableStatus.isValue();
        System.out.println("key=" + key);
        System.out.println("value=" + value);
    }

    @Test
    void calculatorTypeTest() {
        CalculatorType calculatorTypeA = CalculatorType.CALC_A;
        System.out.println(calculatorTypeA.calculate(100L));
        CalculatorType calculatorTypeB = CalculatorType.CALC_B;
        System.out.println(calculatorTypeB.calculate(100L));
        CalculatorType calculatorTypeC = CalculatorType.CALC_C;
        System.out.println(calculatorTypeC.calculate(100L));
    }

    @Test
    void payGroupTest() {
        String payCode = "BAEMIN_PAY";
        PayGroup payGroup = PayGroup.findByPayCode(payCode);
        System.out.println(payGroup);
        System.out.println(payGroup.getTitle());
        System.out.println(payGroup.getPayList());
    }

    @Test
    void payGroupAdvancedTest() {
        PayType payType = PayType.BAEMIN_PAY;
        PayGroupAdvanced payGroupAdvanced = PayGroupAdvanced.findByPayType(payType);
        System.out.println(payGroupAdvanced);
        System.out.println(payGroupAdvanced.name());
        System.out.println(payGroupAdvanced.getTitle());
    }

    @Test
    void enumFunctionTest() {
        var result = ApiEnum.API_A.make("test");
        System.out.println(result);
    }


}
