package com.example.demo.controller.shop;

import com.example.demo.entity.shop.Order;
import com.example.demo.service.shop.CustomerService;
import com.example.demo.service.shop.OrderService;
import com.example.demo.service.shop.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final CustomerService customerService;
    private final ProductService productService;
    private final OrderService orderService;

    // 주문 등록 기능 처리
    @PostMapping("/order/new")
    public void insertOrder(Long customerId, Long productId, int count) {
        orderService.insertOrder(customerId, productId, count);
    }

    // 주문 목록 검색 기능 처리
    @RequestMapping("/getOrderList")
    public List<Order> getOrderList(Order order) {
        List<Order> orderList = orderService.getOrderList(order);
        return orderList;
    }

    // 주문 취소
    @GetMapping("/order/{orderId}/orderCancel")
    public void orderCancel(@PathVariable("orderId") Long orderId) {
        orderService.orderCancel(orderId);
    }
}
