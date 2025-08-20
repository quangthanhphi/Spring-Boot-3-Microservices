package com.spring.microservices.order.service;

import com.spring.microservices.order.dto.OrderRequest;
import com.spring.microservices.order.model.Order;
import com.spring.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        // map orderRequest to orderObject
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        // save order to orderRepository
        orderRepository.save(order);
    }
}
