package com.example.demo.service;

import com.example.demo.dto.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrders();
    Order getOrderById(Long id);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
