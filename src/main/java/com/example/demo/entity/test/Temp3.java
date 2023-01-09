package com.example.demo.entity.test;

import com.fasterxml.uuid.Generators;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Temp3 {

    @Id
    @Builder.Default
    private String id = Generators.timeBasedGenerator().generate().toString();
    private String name;
    private int age;

}
