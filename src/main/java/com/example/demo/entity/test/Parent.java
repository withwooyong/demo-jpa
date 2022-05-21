package com.example.demo.entity.test;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // mappedBy 추가
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children = new ArrayList<>();

    protected Parent() {
    }

    public Parent(String name) {
        this.name = name;
    }

    public Parent(String name, List<Child> children) {
        this.name = name;
        this.children.addAll(children);
    }
}