package com.example.demo.domain;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String address;
    private String kitchenSpeciality;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> staff;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TableInRestaurant> tables;
    private Double latitude;
    private Double longitude;

    public Restaurant() { }

    public Restaurant(String restaurantName, String address, String kitchenSpeciality, Set<Employee> staff, Set<TableInRestaurant> tables, Double latitude, Double longitude) {
        this.restaurantName = restaurantName;
        this.address = address;
        this.kitchenSpeciality = kitchenSpeciality;
        this.staff = staff;
        this.tables = tables;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKitchenSpeciality() {
        return kitchenSpeciality;
    }

    public void setKitchenSpeciality(String kitchenSpeciality) {
        this.kitchenSpeciality = kitchenSpeciality;
    }

    public Set<Employee> getStaff() {
        return staff;
    }

    public void setStaff(Set<Employee> staff) {
        this.staff = staff;
    }

    public Set<TableInRestaurant> getTables() {
        return tables;
    }

    public void setTables(Set<TableInRestaurant> tables) {
        this.tables = tables;
    }
}
