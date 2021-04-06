package com.example.shop.service;

import com.example.shop.model.Order;

import java.util.List;

public interface IOrderService {
    void saveOrder(Order order);

    void deleteOrder(Order order);

    List<Order> ordersOfUser(String userId);
}
