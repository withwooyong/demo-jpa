package com.example.demo.entity.test;

import com.example.demo.util.ObjectId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Temp5 {

    @Id
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "CHAR(24)")
    @Builder.Default
    private String id = ObjectId.generator();
    private String name;
    private int age;

    @Builder.Default
    private LocalDateTime registDate = LocalDateTime.now();

}
