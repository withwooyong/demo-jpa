package com.example.demo.entity.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class PackagesV2 {

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