package com.example.demo.service;

import com.example.demo.domain.Dish;
import com.example.demo.domain.Drink;
import com.example.demo.domain.Menu;
import com.example.demo.domain.Restaurant;

import java.util.List;

public interface MenuService {
    Restaurant addMenuToRestaurant(Long id, Menu menu);
    Restaurant addDishToMenu(Long id, Dish dish);
    Restaurant addDrinkToMenu(Long id, Drink drink);
    List<Menu> getMenus();
    //todo: feature edit one dish for one restaurant
    //todo: feature delete one dish for one restaurant
    //todo: feature edit one drink for one restaurant
    //todo: feature delete one drink for one restaurant
    //todo(deprecated): feature get one dish from menu for one restaurant
    //todo(deprecated): feature get one drink from menu for one restaurant

}
