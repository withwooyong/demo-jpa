package com.example.demo.entity.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String name;

    private int price;
    private int quantity;

    @Builder
    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void reduceStock(int quantity) {
        this.quantity -= quantity;
        if (quantity < 0) {
            throw new IllegalStateException("재고부족");
        }
    }

    public void restoreStock(int quantity) {
        this.quantity += quantity;
    }
}
