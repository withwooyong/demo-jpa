package com.example.demo.service.shop;

import com.example.demo.entity.shop.Customer;
import com.example.demo.entity.shop.Item;
import com.example.demo.entity.shop.Order;
import com.example.demo.entity.shop.Product;
import com.example.demo.repository.shop.CustomerRepository;
import com.example.demo.repository.shop.OrderRepository;
import com.example.demo.repository.shop.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    // 주문 등록
    public void insertOrder(Long customerId, Long productId, int count) {
        Customer customer = customerRepository.getCustomer(customerId);
        Product product = productRepository.getProduct(productId);

        Item item = new Item(product, count);
        Order order = new Order(customer, item);

        orderRepository.insertOrder(order);
    }

    // 주문 취소
    public void orderCancel(Long orderId) {
        Order order = orderRepository.getOrder(orderId);
        order.orderCandel();
    }

    // 주문 목록
    public List<Order> getOrderList(Order order) {
        return orderRepository.getOrderList(order);
    }
}
