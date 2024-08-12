package com.example.demo.service.jpa;

import com.example.demo.annotations.Exception;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repository.JpaOrderRepository;
import com.example.demo.repository.JpaUserRepository;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JpaOrderService implements OrderService {

    private final JpaOrderRepository orderRepository;

    private final JpaUserRepository userRepository;

    @Override
    @Exception
    public Order createOrder(Long userId, Order order) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
         throw new RuntimeException("User does not exists");
        }
        order.setUser(user);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Long orderId, Order orderInfo) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setDescription(orderInfo.getDescription());
            order.setStatus(orderInfo.getStatus());
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
