package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String surname;
    private String name;
    @Column(unique = true)
    private long telephone;
    private String password;
    private String address;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> myOrders;
    private Double latitude;
    private Double longitude;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    private Restaurant placeOfWork;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private boolean isWorking;
}
