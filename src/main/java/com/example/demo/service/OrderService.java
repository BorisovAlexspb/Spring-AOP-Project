package com.example.demo.service;

import com.example.demo.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Long userId, Order order) ;
    List<Order> getOrders();
    Order getOrderById(Long id);
    Order updateOrder(Long orderId, Order orderInfo);
    void deleteOrder(Long id);
}
