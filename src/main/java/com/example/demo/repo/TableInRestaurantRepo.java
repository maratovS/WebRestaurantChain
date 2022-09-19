package com.example.demo.repo;

import com.example.demo.domain.TableInRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableInRestaurantRepo extends JpaRepository<TableInRestaurant, Long> {
}
