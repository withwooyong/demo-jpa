package com.example.demo.service.shop;

import com.example.demo.entity.shop.Customer;
import com.example.demo.repository.shop.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // 회원 등록
    @Transactional
    public void insertCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    // 회원 상세 조회
    @Transactional(readOnly = true)
    public Customer getCustomer(Long customerId) {
        return customerRepository.getCustomer(customerId);
    }

    // 회원 목록 검색
    @Transactional(readOnly = true)
    public List<Customer> getCustomerList() {
        return customerRepository.getCustomerList();
    }
}
