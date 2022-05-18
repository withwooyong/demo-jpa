package com.example.demo.controller.shop;

import com.example.demo.entity.shop.Address;
import com.example.demo.entity.shop.Customer;
import com.example.demo.service.shop.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // 회원 등록
    @PostMapping("/customer/new")
    public void insertCustomer(Customer customer, Address address) {
        customer.setAddress(address);
        customerService.insertCustomer(customer);
    }

    // 회원 목록
    @GetMapping("/getCustomerList")
    public List<Customer> getCustomerList() {
        var result = customerService.getCustomerList();
        log.info(result.toString());
        return result;
    }
}
