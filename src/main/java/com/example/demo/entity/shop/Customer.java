package com.example.demo.entity.shop;

import javax.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString(exclude = "ordersList")
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue
    @Column(name = "customer_id")
    private Long id;

    private String name;
    private String phone;
    private String comments;

    //    private String city;
//    private String roadName;
//    private String zipCode;
    @Setter
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> ordersList = new ArrayList<>();

    @Builder
    public Customer(String name, String phone, String comments, Address address, List<Order> ordersList) {
        this.name = name;
        this.phone = phone;
        this.comments = comments;
        this.address = address;
        this.ordersList = ordersList;
    }
}
