package com.example.demo.service;

import com.example.demo.domain.Restaurant;
import com.example.demo.domain.User;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getRestaurants();
    Restaurant getRestaurant(Long id);
    Restaurant addRestaurant(Restaurant restaurant);
    void deleteRestaurant(Long id);
    Restaurant getAJob(Long id, List<User> unemployed);
    //todo: feature for edit restaurant
}
