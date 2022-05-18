package com.example.demo.dto.test;

import com.study.querydsl.entity.PackagesV2;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class OrderItemRequestTest {

    @Test
    void orderItemRequestTest() {
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(CartItem.builder().cartSeq(1).cartType("cartType1").packageName("name1").productSeq(null).build());
        cartItemList.add(CartItem.builder().cartSeq(2).cartType("cartType2").packageName("name2").productSeq(1).build());
        cartItemList.add(CartItem.builder().cartSeq(3).cartType("cartType3").packageName("name3").productSeq(2).build());
        boolean isEntrancedUser = false;
        OrderItemRequest orderItemRequest = new OrderItemRequest(cartItemList, isEntrancedUser,
                PackagesV2.builder().packageSeq(10).build());
        System.out.println(orderItemRequest);
    }
}