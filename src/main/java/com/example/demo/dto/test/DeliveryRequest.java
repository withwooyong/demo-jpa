package com.example.demo.dto.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class DeliveryRequest {
    private String name;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String cellphone;
    private String message;

    @Builder
    public DeliveryRequest(String name, String zipcode, String addr1, String addr2, String cellphone, String message) {
        this.name = name;
        this.zipcode = zipcode;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.cellphone = cellphone;
        this.message = message;
    }
}
