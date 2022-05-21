package com.example.demo.test;

import com.example.demo.dto.test.Item;
import com.example.demo.dto.test.YndDTO;
import com.example.demo.dto.test.YndOrderBankVO;
import com.example.demo.dto.test.YndOrderParamVO;
import com.example.demo.dto.test.YndOrderUserVO;
import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ArrayList;
import java.util.List;

public class NullCheckTest {

    public static void main(String[] args) {
        String deliver = "false";
        Item item1 = Item.builder().a("a").b("b1").c("c1").packageTypeEnum(Item.PackageTypeEnum.APP).build();
        Item item2 = Item.builder().a("a2").b("b2").c("c2").packageTypeEnum(Item.PackageTypeEnum.CLASS).build();
        Item item3 = Item.builder().a("a3").b("b3").c("c3").packageTypeEnum(Item.PackageTypeEnum.REAL).build();
        Item item4 = Item.builder().a("a1").b("b4").c("c4").packageTypeEnum(Item.PackageTypeEnum.APP).build();

        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        System.out.println(items);
        var result = items.stream().filter(item -> item.getA().equalsIgnoreCase("a1")).findFirst();
        if (result.isPresent()) {
            deliver = "true";
        }
        System.out.println(result);
        System.out.println(deliver);
    }

    @Test
    void yndDTOTest() {
        YndDTO yndDTO = new YndDTO();
        yndDTO.setYndOrderParamVO(YndOrderParamVO.builder().price(1000).build());
        System.out.println(yndDTO.toString());
    }

    @Test
    void java11isBlankTest() {
        String isBlank = " ";
        if (isBlank.isBlank()) {
            System.out.println("isBlank");
        }

        YndOrderUserVO yndOrderUserVO = YndOrderUserVO.builder().userid("userId").build();
        if (yndOrderUserVO.getCellphone().isBlank()) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }

    @Test
    void ifTest() {
        var result = LocaleContextHolder.getLocale();
        System.out.println(result);

    }

    @Test
    void forTest() {
        List<YndOrderUserVO> yndOrderUserVOList = new ArrayList<>();
        YndOrderUserVO yndOrderUserVO = YndOrderUserVO.builder().userid("userId").build();
        yndOrderUserVOList.add(yndOrderUserVO);

        YndDTO yndDTO = new YndDTO();
        yndDTO.setYndOrderUserVO(yndOrderUserVO);
        yndDTO.setYndOrderUserVOList(yndOrderUserVOList);
        System.out.println(yndDTO.toString());
        System.out.println(yndDTO.getYndOrderParamVOList().size());

        for (YndOrderParamVO yndOrderParamVO : yndDTO.getYndOrderParamVOList()) {
            System.out.println("###");
        }

        yndDTO.setYndOrderUserVO(null);
        System.out.println("=============");
        System.out.println(yndDTO.getYndOrderUserVO());
    }

    @Test
    void yndOrderBankVOTest() {
        YndOrderBankVO yndOrderBankVO = new YndOrderBankVO();
        System.out.println(yndOrderBankVO.toString());
    }


}
