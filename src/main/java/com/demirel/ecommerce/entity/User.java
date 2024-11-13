package com.demirel.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user", schema = "ecommerce")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username can't be null!")
    @Size(min = 3, max = 32, message = "Username length should be between 3 and 32!")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Password can't be null!")
    @Size(min = 8, max = 64, message = "Password length should be between 8 and 64!")
    @Column(name = "password")
    private String password;

    @NotNull(message = "Email can't be null!")
    @Column(name = "email")
    private String email;

    @NotNull(message = "Birth Date can't be null!")
    @Column(name = "birth_date")
    private Date birthDate;

    @NotNull(message = "Role can't be null!")
    @Column(name = "role")
    private Short role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("shops")
    private List<Shop> shops;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ProductComment> productComments;
}
