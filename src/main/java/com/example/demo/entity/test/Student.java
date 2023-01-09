package com.example.demo.entity.test;

import javax.persistence.*;

import lombok.Getter;

@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}