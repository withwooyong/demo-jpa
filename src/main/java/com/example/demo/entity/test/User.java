package com.example.demo.entity.test;

import javax.persistence.*;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "G_ID")
    private Group group;

    public void setGroup(Group group) {
//        if (this.group != null) {
//            this.group.getUsers().remove(this);
//        }
        this.group = group;
        group.getUsers().add(this);
    }
}
