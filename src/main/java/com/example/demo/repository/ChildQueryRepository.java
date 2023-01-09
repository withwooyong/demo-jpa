package com.example.demo.repository;

import com.example.demo.entity.test.Child;
import com.example.demo.entity.test.QChild;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChildQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Child findById(Long id) {
        QChild qChild = QChild.child;
        return queryFactory.selectFrom(qChild)
                .where(qChild.id.eq(id))
                .fetchOne();
    }
//
//    public List<AcPurchase> findAll() {
//        QAcPurchase qAcPurchase = QAcPurchase.acPurchase;
//        return queryFactory.selectFrom(qAcPurchase)
//                .fetch();
//    }
}
