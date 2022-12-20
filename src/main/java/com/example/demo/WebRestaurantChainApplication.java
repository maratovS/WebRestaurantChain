package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.repo.*;
import com.example.demo.service.UserService;
import org.hibernate.internal.util.collections.SingletonIterator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class WebRestaurantChainApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRestaurantChainApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CommandLineRunner run(RoleRepo roleRepo,
								 UserRepo userRepo,
								 UserService userService,
								 RestaurantRepo restaurantRepo,
								 OrderRepo orderRepo,
								 TableInRestaurantRepo tableInRestaurantRepo,
								 MenuRepository menuRepository
	) throws Exception{
		return (String[] args) -> {
			if (roleRepo.findAll().isEmpty()){
				roleRepo.save(new Role(null, "client"));
				roleRepo.save(new Role(null, "chef"));
				roleRepo.save(new Role(null, "manager"));
				roleRepo.save(new Role(null, "admin"));
				roleRepo.save(new Role(null, "deliveryman"));
			}
			if (restaurantRepo.findAll().isEmpty()){
				List<Dish> dishes = new ArrayList<>();
				dishes.add(new Dish(
						null,
						"Рамен",
						"Лапша",
						"Любимая еда нашего любимого героя детства",
						101.00,
						100.0,
						400.0,
						null
				));
				List<Drink> drinks = new ArrayList<>();
				drinks.add(new Drink(
						null,
						"Вода",
						"Напиток безалкогольный",
						"Вода.",
						101.00,
						100.0,
						400.0,
						null
				));


				Menu menu = new Menu(
						null,
						dishes,
						drinks
				);

				Restaurant restaurant = restaurantRepo.save(new Restaurant(
						null,
						"Хокку",
						"Московское шоссе, 36А",
						"",
						"Японская кухня",
						"https://grandgames.net/puzzle/f1200/yaponskij_restoran.jpg",
						null,
						null,
						null,
						menu,
						53.212528,
						50.180862
				));
				menu = restaurant.getMenu();
				List<TableInRestaurant> tables = new ArrayList<>();
				for (int i = 0; i < 8; i++) {
					tables.add(new TableInRestaurant(
							null,
							restaurant,
							null,
							3,
							false,
							null
					));
				}
				restaurant.setTables(tables);
				restaurantRepo.save(restaurant);
			}
			if (userRepo.findAll().isEmpty()){
				userService.addUser(new User(
						null,
						"Маратов",
						"Серик",
						9093717141L,
						"overlord",
						"Московское шоссе, 34Б",
						null,
						53.212765,
						50.178401,
						null,
						roleRepo.findByRoleName("client"),
						false
				));
				userService.addUser(new User(
						null,
						"Малинин",
						"Игорь",
						9608223422L,
						"overlord",
						"ул. Севастопольская, дом 37",
						null,
						53.225436,
						50.263300,
						restaurantRepo.findByRestaurantName("Хокку"),
						roleRepo.findByRoleName("deliveryman"),
						true
				));
				userService.addUser(new User(
						null,
						"Геккель",
						"Виктория",
						9099999999L,
						"overlord",
						"5-я просека, 109",
						null,
						53.242037,
						50.184024,
						restaurantRepo.findByRestaurantName("Хокку"),
						roleRepo.findByRoleName("manager"),
						true
				));
				userService.addUser(new User(
						null,
						"Толч",
						"Алексей",
						9099999998L,
						"overlord",
						"Московское шоссе, 34Б",
						null,
						53.242037,
						50.184024,
						restaurantRepo.findByRestaurantName("Хокку"),
						roleRepo.findByRoleName("admin"),
						true
				));
				userService.addUser(new User(
						null,
						"Иван",
						"Луника",
						9099999997L,
						"overlord",
						"5-я просека, 109",
						null,
						53.242037,
						50.184024,
						null,
						roleRepo.findByRoleName("chef"),
						true
				));
				userService.addUser(new User(
						null,
						"Каликин",
						"Михаил",
						9099999996L,
						"overlord",
						"Московское шоссе, 34Б",
						null,
						53.242037,
						50.184024,
						restaurantRepo.findByRestaurantName("Хокку"),
						roleRepo.findByRoleName("chef"),
						true
				));
			}
		};
	}
}
