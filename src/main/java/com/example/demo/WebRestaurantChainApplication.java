package com.example.demo;

import com.example.demo.domain.Restaurant;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repo.RestaurantRepo;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
								 RestaurantRepo restaurantRepo
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
				restaurantRepo.save(new Restaurant(
						null,
						"Хокку",
						"Московское шоссе, 36А",
						"Японская кухня",
						"",
						null,
						null,
						null,
						null,
						53.212562,
						50.180840
				));
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
						restaurantRepo.findByRestaurantName("Хокку"),
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
						roleRepo.findByRoleName("client"),
						true
				));
			}
		};
	}


}
