package com.example.demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TableInRestaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurantId;
    private Integer numberOfSeats;
    private boolean isBooked;
    private Date startOfBookingTime;
    private Date endOfBookingTime;

    public TableInRestaurant() {
    }

    public TableInRestaurant(Restaurant restaurantId, Integer numberOfSeats, boolean isBooked, Date startOfBookingTime, Date endOfBookingTime) {
        this.restaurantId = restaurantId;
        this.numberOfSeats = numberOfSeats;
        this.isBooked = isBooked;
        this.startOfBookingTime = startOfBookingTime;
        this.endOfBookingTime = endOfBookingTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurant restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Date getStartOfBookingTime() {
        return startOfBookingTime;
    }

    public void setStartOfBookingTime(Date startOfBookingTime) {
        this.startOfBookingTime = startOfBookingTime;
    }

    public Date getEndOfBookingTime() {
        return endOfBookingTime;
    }

    public void setEndOfBookingTime(Date endOfBookingTime) {
        this.endOfBookingTime = endOfBookingTime;
    }
}
