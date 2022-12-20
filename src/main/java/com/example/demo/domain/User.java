package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usr")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class User implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String surname;
    private String name;
    @Column(unique = true)
    private long telephone;
    private String password;
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> myOrders;
    private Double latitude;
    private Double longitude;
    @ManyToOne
    @JoinColumn(name = "place_of_work_id")
    @JsonBackReference(value = "placeOfWork")
    private Restaurant placeOfWork;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private boolean working;
}
