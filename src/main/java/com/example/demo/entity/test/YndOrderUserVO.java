package com.example.demo.entity.test;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class YndOrderUserVO {
    private String userid;
    private int idnum;
    private String addr1;
    private String addr2;
    private String cellphone;

    @Builder
    public YndOrderUserVO(String userid, int idnum, String addr1, String addr2, String cellphone) {
        this.userid = userid;
        this.idnum = idnum;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.cellphone = cellphone;
    }

    // 전화번호 Validate
    public String getCellphone() {
        if (this.cellphone == null || this.cellphone.isBlank() || this.cellphone.length() > 20) {
            this.cellphone = "";
        }
        return this.cellphone;
    }

    public static void main(String[] args) {
        YndOrderUserVO yndOrderUserVO = new YndOrderUserVO();
        yndOrderUserVO.setCellphone("012345678901234567891");
        System.out.println(yndOrderUserVO.toString());


    }
}