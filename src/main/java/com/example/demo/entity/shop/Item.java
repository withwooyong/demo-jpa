package com.example.demo.entity.shop;

import javax.persistence.*;

import lombok.*;

@Getter
@ToString(exclude = {"order", "product"})
@Entity
@Table(name = "item")
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int count;

    @Builder
    public Item(Order order, Product product, int count) {
        this.order = order;
        this.product = product;
        this.count = count;
    }

    public Item(Product product, int count) {
        this.product = product;
        this.count = count;

        reduceStock(count);
    }

    public void reduceStock(int count) {
        product.reduceStock(count);
    }

    public void restoreStock() {
        product.restoreStock(count);
    }
}
