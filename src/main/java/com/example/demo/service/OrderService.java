package com.example.demo.service;

import com.example.demo.domain.Dish;
import com.example.demo.domain.Drink;
import com.example.demo.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    List<Order> getOrdersOfUser(Long id);
    List<Order> getOrdersOfRestaurant(Long id);
    Order addOrder(Order order);
    //todo: feature for edit order
    //todo: feature for delete order
    //todo: feature for change order status
}
