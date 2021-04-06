package com.example.shop.service;

import com.example.shop.dto.OrderDto;
import com.example.shop.model.Order;
import com.example.shop.repository.IOrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest(properties = "spring.profiles.active:test")
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class OrderServiceTest {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderRepository orderRepository;

    private OrderDto orderDto;

    @BeforeEach
    public void init() {
        orderDto = OrderDto.builder()
                .userId("userId")
                .orderName("orderName")
                .build();
        orderService.saveOrder(orderDto.convertToOrder());
    }

    @AfterEach
    public void tearDown() {
        List<Order> orders = orderRepository.findAll();
        for ( Order order : orders) {
            orderRepository.delete(order);
        }
    }

    @Test
    public void test_saveOrder() {
        List<Order> orders = orderRepository.findAll();
        Assertions.assertThat(orders).hasSize(1);
    }

    @Test
    public void test_ordersOfUser() {
        // initially user has 1 order from init method
        List<Order> orders = orderRepository.findByUserId(orderDto.getUserId());
        Assertions.assertThat(orders).hasSize(1);

        // add another order
        orderDto = OrderDto.builder()
                .userId("userId")
                .orderName("orderNUmber2")
                .build();
        orderService.saveOrder(orderDto.convertToOrder());

        // verify the new order was added
        orders = orderRepository.findByUserId(orderDto.getUserId());
        Assertions.assertThat(orders).hasSize(2);
    }
}
