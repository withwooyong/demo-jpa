package com.example.demo.entity.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@ToString
@Embeddable
@NoArgsConstructor
public class Address {

    private String city;
    private String roadName;
    private String zipCode;

    @Builder
    public Address(String city, String roadName, String zipCode) {
        this.city = city;
        this.roadName = roadName;
        this.zipCode = zipCode;
    }
}
