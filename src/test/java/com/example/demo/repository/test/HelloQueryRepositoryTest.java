package com.example.demo.repository.test;

import com.example.demo.entity.test.Hello;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HelloQueryRepositoryTest {

    //    private final JPAQueryFactory queryFactory;
    @Autowired
    EntityManager entityManager;
    @Autowired
    HelloQueryRepository repository;

    @BeforeEach
    void setUp() {
        entityManager.persist(Hello.builder().name("name").build());
        entityManager.flush();
//        queryFactory.insert()
    }

    @Test
    void findById() {

    }

    @Test
    void findAll() {
        List<Hello> all = repository.findAll();
        all.forEach(System.out::println);
    }
}