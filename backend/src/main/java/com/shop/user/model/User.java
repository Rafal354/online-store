package com.shop.user.model;

import com.shop.order.model.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Integer age;

    @Column
    private Integer amount;

    @Column
    private String email;

    @Column
    private String password;

    @Column(name = "user_type")
    private UserType userType;

    @Column
    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    public User() {

    }
}
