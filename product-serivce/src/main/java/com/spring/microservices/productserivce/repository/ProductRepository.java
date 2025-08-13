package com.spring.microservices.productserivce.repository;

import com.spring.microservices.productserivce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {}
