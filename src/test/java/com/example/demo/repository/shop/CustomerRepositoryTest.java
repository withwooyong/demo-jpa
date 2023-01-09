package com.example.demo.repository.shop;

import com.example.demo.entity.shop.Address;
import com.example.demo.entity.shop.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CustomerRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void setUp() {
        insertCustomer();
    }

    @Test
    void insertCustomer() {
        var customer = Customer.builder()
                .name("name")
                .address(Address.builder().city("city").roadName("road").zipCode("zip").build())
                .phone("010")
                .comments("comments")
                .build();
        em.persist(customer);

        var customer2 = Customer.builder()
                .name("name2")
                .address(Address.builder().city("city2").roadName("road2").zipCode("zip2").build())
                .phone("010")
                .comments("comments")
                .build();
        em.persist(customer2);
    }

    @Test
    void getCustomer() {
        var result = em.find(Customer.class, 1L);
        System.out.println(result);
    }

    @Test
    void getCustomerList() {
        var result = em.createQuery("SELECT c FROM Customer c ORDER BY c.id", Customer.class).getResultList();
        for (Customer customer : result) {
            System.out.println(customer);
        }
    }
}