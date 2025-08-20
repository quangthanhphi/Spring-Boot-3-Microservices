package com.spring.microservices.productserivce.repository;

import com.spring.microservices.productserivce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

// tác dụng cảu repository là cung cấp các phương thức để truy cập và thao tác với cơ sở dữ liệu.
// MongoRepository là một interface của Spring Data MongoDB, cung cấp các phương thức CRUD cơ bản cho các đối tượng MongoDB.
// Product là kiểu dữ liệu của đối tượng mà chúng ta muốn thao tác, và String là kiểu dữ liệu của khóa chính (ID) của đối tượng đó.
public interface ProductRepository extends MongoRepository<Product, String> {}
