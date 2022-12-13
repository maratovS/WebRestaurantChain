package com.example.demo.domain;

import lombok.*;
import javax.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String address;
    private String kitchenSpeciality;
    private String wallpaperURL;
    @OneToMany
    private List<User> staff;
    @OneToMany
    private List<Order> orders;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<TableInRestaurant> tables;
    @OneToOne
    private Menu menu;
    private Double latitude;
    private Double longitude;
}
