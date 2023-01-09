package com.example.demo.entity.test;

import javax.persistence.*;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group")
    private List<User> users = new ArrayList<User>();

    public void addUser(User user) {
        this.users.add(user);
        if (user.getGroup() != null) {
            user.setGroup(this);
        }
    }
}
