package com.example.demo.repository.test;

import com.example.demo.entity.test.Hello;
import com.example.demo.entity.test.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class HelloQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Hello findById(UUID id) {
        QHello qHello = QHello.hello;
        return queryFactory.selectFrom(qHello)
                .where(qHello.id.eq(id))
                .fetchOne();
    }

    public List<Hello> findAll() {
        QHello qHello = QHello.hello;
        return queryFactory.selectFrom(qHello)
                .fetch();
    }
}
