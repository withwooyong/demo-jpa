package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table
@Getter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Parent {

    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.PERSIST)
    // private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();
    // @ManyToOne
    //    @JoinColumn(name = "item_id")  // 관계테이블 생성 안함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.PERSIST)
    Set<Child> child = new LinkedHashSet<>();

    public void addChild(Child child) {
        this.child.add(child);
    }

    public void addAllChild(Set<Child> childs) {
        this.child.addAll(childs);
    }
}
