package com.aammeerr.springmvcmodulejsonview.entity;

import com.aammeerr.springmvcmodulejsonview.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserSummary.class)
    private Long id;

    @JsonView(Views.UserSummary.class)
    @NotEmpty(message = "Name is required")
    private String name;

    @JsonView(Views.UserSummary.class)
    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @JsonView(Views.UserDetails.class)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonProperty("orders")
    private List<Order> orders;
}
