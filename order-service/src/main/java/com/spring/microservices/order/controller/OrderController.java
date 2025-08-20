package com.spring.microservices.order.controller;

import com.spring.microservices.order.dto.OrderRequest;
import com.spring.microservices.order.service.OrderService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder (@RequestBody OrderRequest orderRequest) {
        orderService.placeOrder(orderRequest);
        return "Order Created Successfully";
    }
}
