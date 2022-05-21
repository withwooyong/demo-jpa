package com.example.demo.test;

import com.example.demo.dto.test.YndOrderDetailVO;
import com.example.demo.dto.test.YndOrderMasterVO;
import com.example.demo.dto.test.YndOrderProductVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {


    //    AtomicInteger productCount = new AtomicInteger();
//    HashMap<String, Object> productCountMap = new HashMap<>();
//        yndDTO.getYndOrderMasterVOList().forEach(yndOrderMasterVO -> {
//        yndDTO.getYndOrderDetailVOList().forEach(yndOrderDetailVO -> {
//            if (yndOrderMasterVO.getPackageSeq() == yndOrderDetailVO.getPackageSeq()) {
//                yndDTO.getYndOrderProductVOList().forEach(yndOrderProductVO -> {
//                    if (yndOrderProductVO.getProductSeq() == yndOrderDetailVO.getProductSeq()) {
//                        // TODO 쿠폰 적용 상품 개수 계산 맞는지 확인 필요.
//                        // packageToProduct.couponUseStatus가 AVAILABLE인 항목의 개수를 구하는 방식에서 구성 상품 중 현물이 아닌 개수를 구하는 방식으로 변경
//                        if (!yndOrderProductVO.getProductTypeCode().equals(ProductTypeEnum.REAL.getCode())) // 현물 아니면 쿠폰 적용 가능
//                            productCount.addAndGet(1);
//                        else yndDTO.getYndOrderParamVO().setDelivery("true");
//                    }
//                });
//            }
//        });
//        productCountMap.put(Integer.toString(yndOrderMasterVO.getPackageSeq()), productCount);
//        productCount.set(0);
//    });

    public static void main(String[] args) {
        List<YndOrderMasterVO> yndOrderMasterVOList = new ArrayList<>();
        yndOrderMasterVOList.add(YndOrderMasterVO.builder().packageSeq(1).orderName("order1").build());
        yndOrderMasterVOList.add(YndOrderMasterVO.builder().packageSeq(2).orderName("order2").build());

        List<YndOrderDetailVO> yndOrderDetailVOList = new ArrayList<>();
        yndOrderDetailVOList.add(YndOrderDetailVO.builder().packageSeq(1).productSeq(1).build());
        yndOrderDetailVOList.add(YndOrderDetailVO.builder().packageSeq(2).productSeq(2).build());

        List<YndOrderProductVO> yndOrderProductVOList = new ArrayList<>();
        yndOrderProductVOList.add(YndOrderProductVO.builder().productSeq(1).productTypeCode("REAL").build());
        yndOrderProductVOList.add(YndOrderProductVO.builder().productSeq(2).productTypeCode("A").build());
        yndOrderProductVOList.add(YndOrderProductVO.builder().productSeq(2).productTypeCode("A").build());

        AtomicInteger productCount = new AtomicInteger();
        HashMap<String, Object> productCountMap = new HashMap<>();
        yndOrderMasterVOList.forEach(yndOrderMasterVO -> {
            yndOrderDetailVOList.forEach(yndOrderDetailVO -> {
                if (yndOrderMasterVO.getPackageSeq() == yndOrderDetailVO.getPackageSeq()) {
                    yndOrderProductVOList.forEach(yndOrderProductVO -> {
                        if (yndOrderProductVO.getProductSeq() == yndOrderDetailVO.getProductSeq()) {
                            if (!yndOrderProductVO.getProductTypeCode().equals("REAL")) {
                                productCount.addAndGet(1);
                                System.out.println("productCount=" + productCount);
                            }
                        }
                    });
                }
            });
            System.out.println("## productCount=" + productCount);
            productCountMap.put(Integer.toString(yndOrderMasterVO.getPackageSeq()), productCount.get());
            productCount.set(0);
        });
        System.out.println(productCountMap);
    }


}
