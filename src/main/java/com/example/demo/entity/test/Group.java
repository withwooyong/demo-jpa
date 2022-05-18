package com.example.demo.entity.test;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@Entity
public class Group {

    @Id
    @Column(name = "G_ID")
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
