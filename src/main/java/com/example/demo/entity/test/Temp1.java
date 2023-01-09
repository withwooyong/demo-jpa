package com.example.demo.entity.test;

import com.fasterxml.uuid.Generators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Temp1 {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @Builder.Default
    private UUID id = Generators.timeBasedGenerator().generate();
    private String name;
    private int age;
}
