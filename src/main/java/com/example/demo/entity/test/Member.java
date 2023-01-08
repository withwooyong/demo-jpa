package com.example.demo.entity.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private int age;

    @Builder
    public Member(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public void updateUserName(String userName) {
        this.userName = userName;
    }
}
