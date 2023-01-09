package com.example.demo.repository.test;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TempQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

//    @PrePersist
//    void saveTemp() {
//        QTemp qTemp1 = Q
//        queryFactory.insert()


}
