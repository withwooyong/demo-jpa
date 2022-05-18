package com.example.demo.entity.test;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartItemResponse {

    private int cartSeq;
    private Integer packageSeq;
    private Integer productSeq;

    @Builder
    public CartItemResponse(int cartSeq, Integer packageSeq, Integer productSeq) {
        this.cartSeq = cartSeq;
        this.packageSeq = packageSeq;
        this.productSeq = productSeq;
    }
}
