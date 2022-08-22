package com.tgt.upcurve.OrderAPI.service;

import com.tgt.upcurve.OrderAPI.entity.Order;
import com.tgt.upcurve.OrderAPI.repository.OrderItemsRepository;
import com.tgt.upcurve.OrderAPI.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;

    public OrderService(OrderRepository orderRepository, OrderItemsRepository orderItemsRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
    }

    public Order fetchOrderByCustomerIdAndOrderId(Integer customerId, Integer orderId) {
        return orderRepository.findOrderByCustomerIdAndOrderId(customerId, orderId);
    }

    public List<Order> fetchOrderByCustomerId(Integer customerId) {
        return orderRepository.findAllByCustomerId(customerId);
    }

    public Order saveOrder(Order order) {
        Order savedOrder = null;
        Order existingOrder = orderRepository.findOrderByCustomerIdAndOrderId(order.getCustomerId(), order.getOrderId());
        if(null == existingOrder){
            savedOrder = orderRepository.save(order);
        }
        return savedOrder;
    }

    public void deleteOrder(Integer customerId, Integer orderId) {
        Order existingOrder = orderRepository.findOrderByCustomerIdAndOrderId(customerId, orderId);
        if(null != existingOrder){
            orderRepository.delete(existingOrder);
        }
    }

}
