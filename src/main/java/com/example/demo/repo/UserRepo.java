package com.example.demo.repo;

import com.example.demo.domain.Restaurant;
import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByTelephone(long telephone);
    List<User> findAllByPlaceOfWorkAndWorking(Restaurant placeOfWork, boolean working);
}
