package com.example.demo.domain;

import lombok.*;
import javax.persistence.*;

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
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> staff;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TableInRestaurant> tables;
    @OneToOne
    private Menu menu;
    private Double latitude;
    private Double longitude;
}
