package com.example.demo.test;

import com.example.demo.dto.test.YndDTO;
import com.example.demo.dto.test.YndOrderParamVO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class YndDTOTest {

    @Test
    void argsTest() {
//        yndApiGatewayServiceV3.getYndPackage(yndOrderMasterVO.getPackageSeq(), yndDTO)

        YndDTO yndDTO = new YndDTO();
        List<YndOrderParamVO> yndOrderParamVOList = new ArrayList<>();
        yndOrderParamVOList.add(YndOrderParamVO.builder().paymentType("type1").build());
        yndOrderParamVOList.add(YndOrderParamVO.builder().paymentType("type2").build());
        yndDTO.setYndOrderParamVOList(yndOrderParamVOList);
        System.out.println("before=" + yndDTO);
        getYndPackage(yndDTO);
        System.out.println("after=" + yndDTO);

    }

    void getYndPackage(YndDTO yndDTO) {
        yndDTO.getYndOrderParamVOList().forEach(yndOrderParamVO -> {
            if (yndOrderParamVO.getPaymentType().equals("type1")) {
                yndOrderParamVO.setPaymentType("type11");
            }
        });
    }
}
