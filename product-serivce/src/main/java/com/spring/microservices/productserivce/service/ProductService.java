package com.spring.microservices.productserivce.service;

import com.spring.microservices.productserivce.dto.ProductRequest;
import com.spring.microservices.productserivce.dto.ProductResponse;
import com.spring.microservices.productserivce.model.Product;
import com.spring.microservices.productserivce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Dung de danh dau day la mot service
@RequiredArgsConstructor // Tao ra constructor tu dong
@Slf4j // Dung de ghi log
public class ProductService {
    private final ProductRepository productRepository; // để truy cap repository

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .skuCode(productRequest.skuCode())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getSkuCode(), product.getPrice()); // Chuyen doi Product thanh ProductResponse
    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream() // Chuyen doi danh sach Product thanh stream, stream là một chuỗi các phần tử có thể xử lý tuần tự
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getSkuCode(), product.getPrice()))  // Chuyen doi Product thanh ProductResponse, dùng ProductResponse để trả về dữ liệu DTO an toàn hơn
                .toList();
    }
}
