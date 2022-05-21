package com.example.demo.entity.shop;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@ToString(exclude = {"customer", "searchCustomerName", "searchOrderStatus", "itemList"})
@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Date orderDate;

    @Builder
    public Order(Customer customer, OrderStatus status, Date orderDate, List<Item> itemList) {
        this.customer = customer;
        this.status = status;
        this.orderDate = orderDate;
        this.itemList = itemList;
    }

    // 검색할 회원 이름
    @Transient
    private String searchCustomerName;

    // 검색할 주문 상태
    @Transient
    private OrderStatus searchOrderStatus;

    // OneToMany 기본설정 FetchType.LAZY
    // 주문내역 목록
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

    // 주문생성자: 회원과 주문 내역 객체를 이용하여 주문을 구성한다.
    public Order(Customer customer, Item item) {
        setCustomer(customer);
        addItem(item);
        this.status = OrderStatus.ORDER; // 주문 생성 시 상태는 ORDER
        this.orderDate = new Date();

    }

    // 회원 설정시에 회원 쪽에도 양방향 참조 설정
    public void setCustomer(Customer customer) {
        this.customer = customer;
        customer.getOrdersList().add(this);
    }

    // 주문내역 설정 시에 주문내역에도 양방향 참조 설정
    public void addItem(Item item) {
        itemList.add(item);
        item.setOrder(this);
    }

    public enum OrderStatus {
        ORDER, CANCEL
    }

    // 주문 취소 처리
    public void orderCandel() {
        this.status = OrderStatus.CANCEL;
        for (Item item : itemList) {
            item.restoreStock();
        }
    }
}
