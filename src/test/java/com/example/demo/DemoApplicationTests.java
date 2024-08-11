package com.example.demo;

import com.example.demo.model.Order;
import com.example.demo.service.jpa.JpaOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	JpaOrderService orderService;
	@Test
	void testBeforeLog() {
		orderService.createOrder(1L, new Order());
	}
}
