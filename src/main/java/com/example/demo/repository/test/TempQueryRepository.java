package com.example.demo.repository.test;

import com.example.demo.entity.test.QTemp5;
import com.example.demo.entity.test.Temp5;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * https://velog.io/@mu1616/Querydsl-%EC%9E%85%EB%AC%B8
 * 데이터 삽입
 * JPAQueryFactory는 insert()를 가지고 있지 않다.
 * insert를 하려면 EntityManager를 사용하자! (SQLQueryFactory는 가능하다)
 */
@Log4j2
@Repository
@RequiredArgsConstructor
public class TempQueryRepository {

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    @Transactional
    public void save5(Temp5 temp) {
        log.info("save5={}", temp.toString());
//        queryFactory.insert(temp1);
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
        entityManager.persist(temp);
//        transaction.commit();
    }

    public Temp5 findByIdTemp5(String id) {
        QTemp5 qTemp = QTemp5.temp5;
        return queryFactory.selectFrom(qTemp)
                .where(qTemp.id.eq(id))
                .fetchOne();
    }

    public List<Temp5> findAllTemp5() {
        QTemp5 qTemp = QTemp5.temp5;
        return queryFactory.selectFrom(qTemp)
                .fetch();
    }

//    @PrePersist
//    void saveTemp() {
//        QTemp qTemp1 = Q
//        queryFactory.insert()


}
