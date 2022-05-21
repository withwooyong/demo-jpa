package com.example.demo.test;

import com.example.demo.dto.test.CartItem;
import com.example.demo.dto.test.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachTest {

    @Test
    void forEachTest1() {
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(CartItem.builder().cartSeq(1).cartType("cartType1").packageName("name1").productSeq(null).build());
        cartItemList.add(CartItem.builder().cartSeq(2).cartType("cartType2").packageName("name2").productSeq(1).build());
        cartItemList.add(CartItem.builder().cartSeq(3).cartType("cartType3").packageName("name3").productSeq(2).build());
        System.out.println(cartItemList);
        cartItemList.forEach(cartItem -> {
            cartItem.setCartType("test");
        });
        System.out.println(cartItemList);
    }

    // for (YndOrderMasterVO yndOrderMasterVO : yndDTO.getYndOrderMasterVOList()) { // PAY_CONFIRM("PAY_CONFIRM", "입금확인중"),
    //            yndOrderMasterVO.updateYndOrderMasterVO(
    //                    PaymentUserEnum.PAY_CONFIRM.getCode(),  // 입금확인중
    //                    yndDTO.getYndOrderParamVO().getPaymentType(),
    //                    yndDTO.getYndOrderParamVO().getPaymentWayCode(),
    //                    yndOrderMasterVO.getSalePrice() - yndOrderMasterVO.getDiscountPrice());
    ////            discountPrice += yndOrderMasterVO.getDiscountPrice(); // 전체 할인 금액 설정
    //
    //            yndOrderCouponServiceV3.calcCouponDiscount(yndOrderMasterVO, yndDTO, productCountMap); // 할인금액 적용
    //            yndDTO.setYndOrderMasterVO(yndOrderMasterVO);   // TODO Ted 여기 이상함.. 왜 List 가 아니지?
    //        }

    @Test
    @DisplayName("call By Reference")
    void objectCallByValueTest2() {
        Person first = new Person("heo", 10);
        Person second = new Person("woo", 20);
        Person third = new Person("yong", 30);
        List<Person> personList = Arrays.asList(first, second, third);
        System.out.println(personList);
        for (Person person : personList) {
            person.setName("Ted");
        }
        System.out.println(personList);
    }

    @Test
    @DisplayName("call By Value int")
    void intCallByValueTest() {
        intMethod_1();
    }

    @Test
    @DisplayName("call By Value String")
    void stringCallByValueTest() {
        stringMethod_1();
    }

    @Test
    @DisplayName("call By Reference Object")
    void objectCallByValueTest() {
        System.out.println("Heap Memory 영역에 생성된 객체의 주소값을 참조하기 때문에 '참조 타입'");
        objectMethod_1();
    }

    public void objectMethod_1() {
        Person person = new Person("woo", 10);
        System.out.println("Before=" + person);
        objectMethod_2(person);
        System.out.println("After=" + person);
    }

    public void objectMethod_2(Person person) {
        person.setAge(20);
        person.setName("yong");
        System.out.println("objectMethod_2=" + person);
    }

    // Call by Value
    public void intMethod_1() {
        int a = 10;
        int b = 5;
        System.out.println("Before a=" + a);
        System.out.println("Before b=" + b);
        intMethod_2(a, b);
        System.out.println("After a=" + a);
        System.out.println("After b=" + b);
    }

    public void intMethod_2(int a, int b) {
        a = 20;
        b = 10;
        System.out.println("intMethod_2 a=" + a);
        System.out.println("intMethod_2 b=" + b);
    }

    // Call by Value
    public void stringMethod_1() {
        String a = "A";
        String b = "B";
        System.out.println("Before a=" + a);
        System.out.println("Before b=" + b);
        stringMethod_2(a, b);
        System.out.println("After a=" + a);
        System.out.println("After b=" + b);
    }

    public void stringMethod_2(String a, String b) {
        a = "C";
        b = "D";
        System.out.println("stringMethod_2 a=" + a);
        System.out.println("stringMethod_2 b=" + b);
    }
}
