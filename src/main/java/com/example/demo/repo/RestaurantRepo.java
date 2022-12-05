package com.example.demo.repo;

import com.example.demo.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
    Restaurant findByRestaurantName(String name);
}
