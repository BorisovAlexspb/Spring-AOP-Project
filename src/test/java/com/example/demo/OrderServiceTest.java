package com.example.demo;


import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.repository.JpaOrderRepository;
import com.example.demo.repository.JpaUserRepository;
import com.example.demo.service.jpa.JpaOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderServiceTest {


    @Mock
    private JpaOrderRepository orderRepository;

    @Mock
    private JpaUserRepository userRepository;

    @InjectMocks
    private JpaOrderService orderService;


    @Test
    void testCreateOrder() {
        User user = new User();
        user.setId(1L);

        Order order = new Order();
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(orderRepository.save(order)).thenReturn(order);

        Order createdOrder = orderService.createOrder(1L, order);

        assertNotNull(createdOrder);
        assertEquals(user, createdOrder.getUser());
        verify(orderRepository, times(1)).save(order);
    }


    @Test
    void testCreateOrder_ThrowException() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> orderService.createOrder(1L, new Order()));
        assertEquals("User does not exists", exception.getMessage());
    }

    @Test
    void testGetAllOrders() {
        Order order = new Order();
        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));

        assertEquals(1, orderService.getOrders().size());
    }

    @Test
    void testGetOrderById() {
        Order order = new Order();
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(1L);

        assertNotNull(foundOrder);
        assertEquals(order, foundOrder);
    }
}
