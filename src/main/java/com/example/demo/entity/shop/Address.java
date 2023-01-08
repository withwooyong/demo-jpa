package com.example.demo.entity.shop;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
