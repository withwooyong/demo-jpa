package com.example.demo.entity.test;

import javax.persistence.*;

import lombok.Getter;

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
}