package kr.co.demo.ch06.repository.shop.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.demo.ch06.entity.shop.Customer;
import kr.co.demo.ch06.entity.shop.QCustomer;
import kr.co.demo.ch06.repository.shop.custom.CustomerRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    private final JPAQueryFactory queryFactory; // 빨간 오류 해결 -> config/QueryDslConfig.java 파일 생성

    private QCustomer qCustomer = QCustomer.customer; // 싱글톤이라고 보면 됨.

    @Override
    public Customer selectCustomer(String custId) {

        return queryFactory.select(qCustomer)
                .from(qCustomer)
                .where(qCustomer.custId.eq(custId))
                .fetchOne();
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return queryFactory.selectFrom(qCustomer).fetch(); // selectFrom - 조건이 없으니깐, 이렇게 붙여서 작성하면 된다.
    }

    @Override
    public List<Customer> selectProjectionCustomer() {
        return queryFactory
                .select(
                        Projections.fields(
                                Customer.class,
                                qCustomer.custId,
                                qCustomer.name,
                                qCustomer.age
                        )
                )
                .from(qCustomer)
                .fetch();
    }

}
