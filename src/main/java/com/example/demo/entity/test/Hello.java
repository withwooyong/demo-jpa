package com.example.demo.entity.test;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Hello {

    @Id
    @Builder.Default
    private UUID id = Generators.timeBasedGenerator().generate();

    private String name;
}
