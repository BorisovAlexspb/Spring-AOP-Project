package com.example.demo.service.jpa;

import com.example.demo.dto.Order;
import com.example.demo.service.OrderService;

import java.util.List;

public class JpaOrderService implements OrderService {
    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return List.of();
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public void deleteOrder(Long id) {

    }
}
