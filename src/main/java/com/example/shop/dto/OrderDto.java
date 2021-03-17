package com.example.shop.dto;

import com.example.shop.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
