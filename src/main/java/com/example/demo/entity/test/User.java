package com.example.demo.entity.test;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@Entity
public class User {

    @Id
    @Column(name = "U_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
