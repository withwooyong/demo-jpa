package com.example.demo.entity.test;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private int age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Getter
    @RequiredArgsConstructor
    public enum RoleType {
        ADMIN, USER
    }

    @Builder
    public Member(String userName, int age) {
        this.userName = userName;
        this.age = age;
        this.roleType = RoleType.USER;  // default 값
    }

    // 사용자 이름 업데이트
    public void updateUserName(String userName) {
        this.userName = userName;
    }

    // 관리자로
    public void setAdmin() {
        this.roleType = RoleType.ADMIN;
    }

    // 사용자로
    public void setUser() {
        this.roleType = RoleType.USER;
    }

}
