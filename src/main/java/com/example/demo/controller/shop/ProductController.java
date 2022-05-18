package com.example.demo.controller.shop;


import com.example.demo.entity.shop.Product;
import com.example.demo.service.shop.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // 상품 등록
    @PostMapping("/product/new")
    public void insertProduct(Product product) {
        productService.insertOrUpdateProduct(product);
    }

    // 상품 정보 상세
    @GetMapping("/product/{productId}/get")
    public Product getProduct(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.getProduct(productId);
        log.info(product.toString());
        return product;
    }


    // 상품 목록
    @GetMapping("/getProductList")
    public List<Product> getProductList() {
        List<Product> productList = productService.getProductList();
        log.info(productList.toString());
        return productList;
    }


}
