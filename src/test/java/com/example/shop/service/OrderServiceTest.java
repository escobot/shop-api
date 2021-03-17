package com.example.shop.service;

import com.example.shop.dto.OrderDto;
import com.example.shop.model.Order;
import com.example.shop.repository.IOrderRepository;
import org.assertj.core.api.Assertions;
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

    @Test
    public void test_saveOrder() {
        OrderDto orderDto = OrderDto.builder()
                .userId("userId")
                .orderName("orderName")
                .build();

        orderService.saveOrder(orderDto.convertToOrder());

        List<Order> orders = orderRepository.findAll();

        Assertions.assertThat(orders).hasSize(1);
    }
}
