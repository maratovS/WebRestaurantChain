package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Restaurant;
import com.example.demo.domain.User;
import com.example.demo.repo.MenuRepository;
import com.example.demo.repo.RestaurantRepo;
import com.example.demo.repo.TableInRestaurantRepo;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TableInRestaurantRepo tableInRestaurantRepo;


    @Override
    public List<Restaurant> getRestaurants() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepo.findById(id).orElse(null);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantRepo.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepo.deleteById(id);
    }

    @Override
    public Restaurant getAJob(Long id, List<User> unemployed) {
        Restaurant restaurant = restaurantRepo.findById(id).orElse(null);
        if (restaurant == null)
            return null;
        restaurant.setStaff(unemployed);
        return restaurantRepo.save(restaurant);
    }
}
