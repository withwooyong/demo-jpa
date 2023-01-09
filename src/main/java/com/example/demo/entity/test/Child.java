package com.example.demo.entity.test;

import javax.persistence.*;

import lombok.Getter;

@Entity
@Getter
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Parent 필드 추가
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;


    protected Child() {
    }

    // 생성자에 Parent 추가
    public Child(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }
}
