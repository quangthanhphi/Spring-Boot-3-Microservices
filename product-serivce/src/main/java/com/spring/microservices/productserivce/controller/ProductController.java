package com.spring.microservices.productserivce.controller;

import com.spring.microservices.productserivce.dto.ProductRequest;
import com.spring.microservices.productserivce.dto.ProductResponse;
import com.spring.microservices.productserivce.model.Product;
import com.spring.microservices.productserivce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Đánh dấu lớp này là một controller trong Spring MVC, cho phép nó xử lý các yêu cầu HTTP.
@RequestMapping("/api/product")
@RequiredArgsConstructor // Tao ra constructor tu dong, khong can khai bao constructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return productService.getAllProducts();
    }
}
