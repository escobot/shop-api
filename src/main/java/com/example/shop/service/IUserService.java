package com.example.shop.service;

import com.example.shop.model.User;
import com.example.shop.projection.CountryAggregation;
import com.example.shop.projection.UserAggregation;

import java.util.List;

public interface IUserService {
    void saveUser(User user);

    void deleteUser(User user);

    List<User> findUsersByCountry(String country);

    List<UserAggregation> groupByCountry();

    List<CountryAggregation> countByCountry();
}
