package com.example.demo.entity.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Entity
@NoArgsConstructor
public class PackagesV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int packageSeq;
    private String title;
    private String subTitle;

    @Builder
    public PackagesV2(int packageSeq, String title, String subTitle) {
        this.packageSeq = packageSeq;
        this.title = title;
        this.subTitle = subTitle;
    }
}