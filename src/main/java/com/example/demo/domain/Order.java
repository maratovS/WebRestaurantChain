package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ordr")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order { //todo: add relations
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    private User user;
    private boolean needDelivery;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unrepresentable_id")
    private TableInRestaurant seatNumber;
}
