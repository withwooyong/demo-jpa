package com.example.demo.repository.test;

import com.example.demo.entity.test.Temp2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@ActiveProfiles("mysql")
class Temp2RepositoryTest {

    @Autowired
    Temp2Repository repository;

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 5).forEach(value -> {
            repository.save(Temp2.builder()
                    .name("name" + value)
                    .age(value * 10)
                    .build());
        });
    }

    @Test
    void findAllTest() {
        List<Temp2> all = repository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void findById() {
        Optional<Temp2> byId = repository.findById(UUID.fromString("40904d9a-8ffd-11ed-9f06-fbace96c5c15"));
        System.out.println(byId);
    }
}