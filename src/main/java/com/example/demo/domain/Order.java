package com.example.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "ordr")
public class Order { //todo: add relations
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unrepresentable_id")
    private TableInRestaurant seatNumber;
    /*
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee worksWith; //todo: set of pipeline employees
                                   */
    private boolean isDone;

    public Order() {
    }

    public Order(Restaurant restaurant, Client client, TableInRestaurant seatNumber, boolean isDone) {
        this.restaurant = restaurant;
        this.client = client;
        this.seatNumber = seatNumber;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public TableInRestaurant getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(TableInRestaurant seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
