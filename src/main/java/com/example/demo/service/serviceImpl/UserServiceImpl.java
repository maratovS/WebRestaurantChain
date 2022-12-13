package com.example.demo.service.serviceImpl;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repo.RoleRepo;
import com.example.demo.repo.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUser(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found in database!");
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString()))
        );

    }

    @Override
    public User getUser(String username) {
        long telephone = Long.parseLong(username);
        return userRepo.findByTelephone(telephone);
    }

    @Override
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<Role> getRoles() {
        return roleRepo.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User savedUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!savedUser.getSurname().equals(user.getSurname())){
            savedUser.setSurname(user.getSurname());
        }
        if (!savedUser.getName().equals(user.getName())){
            savedUser.setName(user.getName());
        }
        if (savedUser.getTelephone() != user.getTelephone()){
            savedUser.setTelephone(user.getTelephone());
        }
        if (!savedUser.getPassword().equals(passwordEncoder.encode(user.getPassword()))){
            savedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (!savedUser.getAddress().equals(user.getAddress())){
            savedUser.setAddress(user.getAddress());
        }
        if (!savedUser.getRole().getRoleName().equals(user.getRole().getRoleName())){
            savedUser.setRole(user.getRole());
        }
        if (savedUser.isWorking() != user.isWorking()){
            savedUser.setWorking(user.isWorking());
        }
        return userRepo.save(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getUnemployed() {
        return userRepo.findAllByPlaceOfWorkAndWorking(null, true);
    }
}
