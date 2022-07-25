package com.tgt.upcurve.OrderAPI.service;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.repository.OrderItemsRepository;
import com.tgt.upcurve.OrderAPI.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderService(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
        this.orderRepository = orderRepository;
    }

    public Order fetchOrderById(Integer orderId) {
        return orderRepository.getById(orderId);
    }
}
