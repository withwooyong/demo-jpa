package com.example.demo.test;

import com.example.demo.dto.test.CartItemResponse;
import com.example.demo.dto.test.YndCouponParamVO;
import com.example.demo.dto.test.YndOrderMasterVO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    @Test
    public void intStream_range() {
        // 1, 2
        IntStream.range(1, 3).forEach(System.out::println);
        System.out.println("=");
        // 1, 2, 3
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    @Test
    public void intStream_rangeClosed() {
        List<CartItemResponse> cartItemResponseList = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(i -> {
            if (i == 3) return;
            cartItemResponseList.add(CartItemResponse.builder()
                    .cartSeq(i)
                    .packageSeq(i + i)
                    .productSeq(i + i + i)
                    .build());
        });
        cartItemResponseList.forEach(System.out::println);

        List<CartItemResponse> list = cartItemResponseList.stream()
                .filter(x -> x.getCartSeq() == 5).collect(Collectors.toList());
        System.out.println(list);
        System.out.println("================");
        // 새로운거 알았네..
//        for (CartItemResponse cartItemResponse : cartItemResponseList) {
//            cartItemResponse.setCartSeq(cartItemResponse.getCartSeq() * 2);
//            cartItemResponse.setPackageSeq(cartItemResponse.getPackageSeq() * 2);
//            cartItemResponse.setProductSeq(cartItemResponse.getProductSeq() * 2);
//        }

        AtomicInteger j = new AtomicInteger(10);
        cartItemResponseList.forEach(cartItemResponse -> {
            cartItemResponse.setCartSeq(cartItemResponse.getCartSeq() * 2);
            cartItemResponse.setPackageSeq(cartItemResponse.getPackageSeq() * 2);
            cartItemResponse.setProductSeq(cartItemResponse.getProductSeq() * 2);
            if (cartItemResponse.getCartSeq() == 20) {
                cartItemResponse.setProductSeq(10000);
            }
            j.addAndGet(10);
        });
        System.out.println(j.get());

        // 위 프린트 문 객체 수정.. Call by ???
        cartItemResponseList.forEach(System.out::println);


    }

    @Test
    void ifCnotinueTest() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0)
                continue;
            // 나머지가 0인 경우 아래의 continue가 실행되어 아래 println 출력 안함.
            System.out.println("i=" + i);

            for (int j = 0; j <= 10; j++) {
                if (j % 2 == 0)
                    continue;
                System.out.println("j=" + j);
            }
            System.out.println("===");
        }
    }


    @Test
    void filterTest() {
        List<CartItemResponse> cartItemResponseList = new ArrayList<>();
        CartItemResponse cartItemResponse = new CartItemResponse();

//        for (CartItemResponse cartItemResponse : cartItemResponseList.stream().filter(x -> x.getProductSeq() == null).collect(Collectors.toList())) {
//            int packageSeq = cartItemResponse.getPackageSeq();
//            PackagesV2 packages = PackagesV2.builder().packageSeq(1).title("title").subTitle("subtitle").build();
//            cartItemResponse.setExceptOptionOriginalPrice(packages.getExceptOptionOriginalPrice());
//            cartItemResponse.setExceptOptionSalePrice(packages.getExceptOptionSalePrice());
//            cartItemResponse.setExceptOptionEarlyBirdSalePrice(packages.getExceptOptionEarlyBirdSalePrice());
//            cartItemResponse.setExceptOptionMembershipSalePrice(packages.getExceptOptionMembershipSalePrice());
//        }
    }

    @Test
    void matchTest() {
        int[] intArr = {2, 4, 6};
        boolean result = Arrays.stream(intArr).allMatch(a -> a % 2 == 0);
        System.out.println("allMatch 2의 배수? " + result);
        result = Arrays.stream(intArr).anyMatch(a -> a % 3 == 0);
        System.out.println("anyMatch 3의 배수가 하나라도 있나? " + result);
        result = Arrays.stream(intArr).noneMatch(a -> a % 3 == 0);
        System.out.println("noneMatch 3의 배수가 없나? " + result);
    }

    @Test
    void forforTest() {
        List<String> list1 = Arrays.asList("a", "b", "c", "d", "e");
        List<String> list2 = Arrays.asList("a", "b", "d");
        // 2중 for문은 stream으로 어떻게 작성할까?
        // 만약 for문을 돌면서 같은 것만 list에 담고 싶다면?
        // 8버전 이전
        List<String> result1 = new ArrayList<>();
        for (String str1 : list1) {
            for (String str2 : list2) {
                if (str1.equals(str2)) {
                    result1.add(str1);
                }
            }
        }
        for (String str : result1) {
            System.out.print(str);
        }
        System.out.println();
        // 8버전 (stream 이용)
        // noneMatch => 불일치 데이터 필터링
        // anyMatch => 일치 데이터 필터링
        // allMatch => 모두 일치하는 데이터 필터링
        List<String> result2 = list1.stream()
                .filter(str -> list2.stream().anyMatch(Predicate.isEqual(str)))
                .collect(Collectors.toList());
        result2.stream().forEach(System.out::print);
        System.out.println();
        result2.forEach(System.out::print);
    }

    // for (YndOrderMasterVO yndOrderMasterVO : yndDTO.getYndOrderMasterVOList()) {
    //                if (yndOrderMasterVO.getDiscountPrice() > 0) {
    //                    for (YndCouponParamVO yndCouponParamVO : yndDTO.getYndCouponParamVOList()) {
    //                        if (yndCouponParamVO.getPackageSeq() == yndOrderMasterVO.getPackageSeq())
    //                            validateDiscountPrice += yndCouponParamVO.getDiscountPrice();
    //                        else throw new CustomException(MessageUtil.getMessage("결제금액 불일치 오류"));
    //                    }
    //                }
    //            }
    @Test
    void stream2Test() {
        List<YndOrderMasterVO> yndOrderMasterVOList = new ArrayList<>();
        yndOrderMasterVOList.add(YndOrderMasterVO.builder().discountPrice(0).orderName("orderName0").packageSeq(0).build());
        yndOrderMasterVOList.add(YndOrderMasterVO.builder().discountPrice(10).orderName("orderName10").packageSeq(1).build());
        yndOrderMasterVOList.add(YndOrderMasterVO.builder().discountPrice(20).orderName("orderName20").packageSeq(2).build());
        yndOrderMasterVOList.add(YndOrderMasterVO.builder().discountPrice(30).orderName("orderName30").packageSeq(3).build());
        System.out.println(yndOrderMasterVOList);
        List<YndCouponParamVO> yndCouponParamVOList = new ArrayList<>();
        yndCouponParamVOList.add(YndCouponParamVO.builder().packageSeq(0).discountPrice(10).build());
        yndCouponParamVOList.add(YndCouponParamVO.builder().packageSeq(1).discountPrice(20).build());
        yndCouponParamVOList.add(YndCouponParamVO.builder().packageSeq(2).discountPrice(30).build());
        yndCouponParamVOList.add(YndCouponParamVO.builder().packageSeq(3).discountPrice(40).build()); // 90 나와야 함.
        System.out.println(yndCouponParamVOList);
        System.out.println("===========");
        int validateDiscountPrice = 0;
        var result = yndOrderMasterVOList.stream()
                .filter(yndOrderMasterVO -> yndOrderMasterVO.getDiscountPrice() > 0)
                .filter(yndOrderMasterVO -> yndCouponParamVOList.stream()
                        .anyMatch(yndCouponParamVO -> yndCouponParamVO.getPackageSeq() == yndOrderMasterVO.getPackageSeq()))
                .collect(Collectors.toList());
        result.forEach(System.out::println);

        var result2 = yndCouponParamVOList.stream()
                .filter(yndCouponParamVO -> yndOrderMasterVOList.stream()
                        .filter(yndOrderMasterVO -> yndOrderMasterVO.getDiscountPrice() > 0)
                        .anyMatch(yndOrderMasterVO -> yndOrderMasterVO.getPackageSeq() == yndCouponParamVO.getPackageSeq())
                ).mapToInt(YndCouponParamVO::getDiscountPrice).sum();
        System.out.println(result2);


    }

}
