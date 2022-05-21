package com.example.demo.dto.test;


import lombok.Data;

@Data
public class YndOrderBankVO {
    private int orderSeq;
    private String orderNo;
    private String vactBankCode; // 입금은행코드
    private String vactBankName; // 입금은행명
    private String vactDate; // 입금기한일자
    private String vactInputName; // 송금자명
    private String vactName; // 예금주명
    private String vactNum; // 가상계좌번호
    private String vactTime;// 입금기한시각
    private int paymentPrice;
}
