package com.spring.microservices.productservice.dto;

import java.math.BigDecimal;

// record là một tính năng mới trong Java 14, cho phép chúng ta định nghĩa các lớp dữ liệu một cách ngắn gọn và dễ đọc hơn.
// record sẽ tự động tạo ra các phương thức getter, equals, hashCode và toString
// cho các trường dữ liệu được định nghĩa trong nó.
// Trong trường hợp này, chúng ta định nghĩa một record ProductRequest với các trường id,
// name, description và price, tương ứng với các thuộc tính của sản phẩm mà chúng ta
// muốn gửi từ client đến server khi tạo hoặc cập nhật sản phẩm.
public record ProductRequest(String id, String name, String description,String skuCode, BigDecimal price) {}
