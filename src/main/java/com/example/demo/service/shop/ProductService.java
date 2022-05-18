package com.example.demo.service.shop;

import com.example.demo.entity.shop.Product;
import com.example.demo.repository.shop.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 상품 등록 혹은 수정
    @Transactional
    public void insertOrUpdateProduct(Product product) {
        productRepository.insertOrUpdateProduct(product);
    }

    // 상품 상세 조회
    @Transactional(readOnly = true)
    public Product getProduct(Long productId) {
        return productRepository.getProduct(productId);
    }

    // 상품 목록 검색
    @Transactional(readOnly = true)
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

}
