package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.repo.RestaurantRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.MenuService;
import com.example.demo.service.RestaurantService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class HomeController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    @GetMapping("/restaurants")
    List<Restaurant> index(){
        return restaurantService.getRestaurants();
    }

    @PostMapping("/addRestaurant")
    Restaurant addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/getRestaurant")
    Restaurant getRestaurant(@RequestParam Long id){
        return restaurantService.getRestaurant(id);
    }

    @GetMapping("/users")
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/menus")
    List<Menu> getMenus(){
        return menuService.getMenus();
    }

    @PostMapping("/addMenu")
    Restaurant addMenuToRestaurant(@RequestParam Long id, @RequestBody Menu menu){
        return menuService.addMenuToRestaurant(id, menu);
    }

    @GetMapping("/unemployed")
    List<User> getUnemployed(){
        return userService.getUnemployed();
    }

    @PostMapping("/getAJob")
    Restaurant getAJob(@RequestParam Long id, @RequestBody List<User> unemployed){
        return restaurantService.getAJob(id, unemployed);
    }

    @PostMapping("/addDish")
    Restaurant addDish(@RequestParam Long id, @RequestBody Dish dish){
        return menuService.addDishToMenu(id, dish);
    }
    @PostMapping("/addDrink")
    Restaurant addDrink(@RequestParam Long id, @RequestBody Drink drink){
        return menuService.addDrinkToMenu(id, drink);
    }
}
