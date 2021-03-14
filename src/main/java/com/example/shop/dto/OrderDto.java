package com.example.shop.dto;

import com.example.shop.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class OrderDto {
    private String orderName;
    private String userId;

    public Order convertToOrder() {
        return Order.builder()
                .orderName(orderName)
                .userId(userId)
                .orderTime(LocalDateTime.now())
                .build();
    }
}
