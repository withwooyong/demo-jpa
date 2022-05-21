package com.example.demo.dto.test;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndDTO {
    private int seq;
    private String name;
    private YndOrderParamVO yndOrderParamVO;
    private List<YndOrderParamVO> yndOrderParamVOList = new ArrayList<>();
    private YndOrderUserVO yndOrderUserVO;
    private List<YndOrderUserVO> yndOrderUserVOList = new ArrayList<>();

    @Builder
    public YndDTO(int seq, String name, YndOrderParamVO yndOrderParamVO, List<YndOrderParamVO> yndOrderParamVOList, YndOrderUserVO yndOrderUserVO, List<YndOrderUserVO> yndOrderUserVOList) {
        this.seq = seq;
        this.name = name;
        this.yndOrderParamVO = yndOrderParamVO;
        this.yndOrderParamVOList = yndOrderParamVOList;
        this.yndOrderUserVO = yndOrderUserVO;
        this.yndOrderUserVOList = yndOrderUserVOList;
    }
}
