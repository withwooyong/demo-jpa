package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString(exclude = "parent")
@NoArgsConstructor
@RequiredArgsConstructor
public class Child {
    // @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = CascadeType.PERSIST)
    // private List<ItemOptionGroup> itemOptionGroupList = Lists.newArrayList();
    // @ManyToOne
    //    @JoinColumn(name = "item_id")  // 관계테이블 생성 안함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")  // 관계테이블 생성 안함
    private Parent parent;

    @Builder
    public Child(@NonNull String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }
}
