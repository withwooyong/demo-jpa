package com.example.demo.repository.test;

import com.example.demo.entity.test.Temp5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@ActiveProfiles("mysql")
class TempQueryRepositoryTest {

    @Autowired
    TempQueryRepository repository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void save5() {
        IntStream.rangeClosed(1, 10).forEach(value -> {
            repository.save5(Temp5.builder()
                    .name("name" + value).age(10 * value).build());
        });
    }

    @Test
    void findByIdTemp5() {
        String id = "63bd38044c59452df900b3e1";
        Temp5 byIdTemp5 = repository.findByIdTemp5(id);
        System.out.println(byIdTemp5);
    }

    @Test
    void findByAllTemp5() {
        List<Temp5> allTemp5 = repository.findAllTemp5();
        allTemp5.forEach(System.out::println);
    }


}