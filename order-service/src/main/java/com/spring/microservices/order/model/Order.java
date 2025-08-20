package com.spring.microservices.order.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity //
@Table(name = "t_orders")
@Setter
@Getter
@AllArgsConstructor // tác dụng của @AllArgsConstructor là tạo ra một constructor với tất cả các trường trong lớp.
@NoArgsConstructor // tác dụng của @NoArgsConstructor là tạo ra một constructor không có tham số.
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng giá trị của id khi thêm bản ghi mới
    private Long id;
    private String orderNumber;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
