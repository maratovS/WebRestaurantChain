package com.example.demo.service.serviceImpl;

import com.example.demo.domain.*;
import com.example.demo.repo.*;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private TableInRestaurantRepo tableInRestaurantRepo;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private DrinkRepository drinkRepository;

    @Override
    public List<Order> getOrders() {
        List<Order> orders = orderRepo.findAll();
        orders.forEach(s ->{
            s.getDishes().forEach(d -> {
                System.out.println(d.getId().toString() + ' ' + d.getName());
            });
            s.getDrinks().forEach(d -> {
                System.out.println(d.getId().toString() + ' ' + d.getName());
            });
        });
        return orders;
    }

    @Override
    public List<Order> getOrdersOfUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> {
                    throw new RuntimeException("User not found");
                })
                .getMyOrders();
    }

    @Override
    public List<Order> getOrdersOfRestaurant(Long id) {
        return restaurantRepo.findById(id)
                .orElseThrow(() ->{
                    throw new RuntimeException("Restaurant not found");
                })
                .getOrders();
    }

    @Override
    public Order addOrder(Order order) {
        Restaurant restaurant = restaurantRepo
                .findById(
                        order.getRestaurant().getId())
                .orElseThrow(() -> {
                    throw new RuntimeException("");
                });
        User user = userRepo.findById(order.getUser().getId())
                .orElseThrow(() -> {
                    throw new RuntimeException("");
                });
        TableInRestaurant seatNumber = tableInRestaurantRepo.findById(order.getSeatNumber().getId())
                .orElseThrow(() -> {
                    throw new RuntimeException("");
                });
        List<Dish> dishes = dishRepository.findAllById(
                order.getDishes()
                .stream().
                map(Dish::getId)
                        .collect(Collectors.toList())
        );
        List<Drink> drinks = drinkRepository.findAllById(
                order.getDrinks()
                        .stream().
                        map(Drink::getId)
                        .collect(Collectors.toList())
        );
        order.setRestaurant(restaurant);
        order.setUser(user);
        order.setSeatNumber(seatNumber);
        order.setDishes(dishes);
        order.setDrinks(drinks);
        dishes.forEach(s -> {
            System.out.println(s.getId().toString() + ' ' + s.getCalories().toString());
        });
        drinks.forEach(s -> {
            System.out.println(s.getId().toString() + ' ' + s.getVolume().toString());
        });
        order.setOrderedTime(new Date(System.currentTimeMillis()));
        return orderRepo.save(order);
    }
}
