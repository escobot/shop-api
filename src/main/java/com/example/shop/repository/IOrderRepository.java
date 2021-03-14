package com.example.shop.repository;

import com.example.shop.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IOrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
}
