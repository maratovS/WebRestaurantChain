package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Dish;
import com.example.demo.domain.Drink;
import com.example.demo.domain.Menu;
import com.example.demo.domain.Restaurant;
import com.example.demo.repo.DishRepository;
import com.example.demo.repo.DrinkRepository;
import com.example.demo.repo.MenuRepository;
import com.example.demo.repo.RestaurantRepo;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Override
    public Restaurant addMenuToRestaurant(Long id, Menu menu) {
        Restaurant restaurant = restaurantRepo.findById(id).orElse(null);
        if (restaurant == null)
            return null;
        menu = menuRepository.save(menu);
        restaurant.setMenu(menu);
        return restaurantRepo.save(restaurant);
    }

    @Override
    public Restaurant addDishToMenu(Long id, Dish dish) {
        Restaurant restaurant = restaurantRepo.findById(id).orElse(null);
        if (restaurant == null)
            return null;
        List<Dish> dishes = restaurant.getMenu().getDishes();
        dishes.add(dish);
        Menu menu = restaurant.getMenu();
        menu.setDishes(dishes);
        menuRepository.save(menu);
        restaurant.setMenu(menu);

        return restaurantRepo.save(restaurant);
    }

    @Override
    public Restaurant addDrinkToMenu(Long id, Drink drink) {
        Restaurant restaurant = restaurantRepo.findById(id).orElse(null);
        if (restaurant == null)
            return null;
        List<Drink> drinks = restaurant.getMenu().getDrinks();
        drinks.add(drink);
        Menu menu = restaurant.getMenu();
        menu.setDrinks(drinks);
        menuRepository.save(menu);
        restaurant.setMenu(menu);

        return restaurantRepo.save(restaurant);
    }

    @Override
    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }
}
