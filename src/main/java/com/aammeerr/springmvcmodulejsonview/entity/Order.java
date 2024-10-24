package com.aammeerr.springmvcmodulejsonview.entity;

import com.aammeerr.springmvcmodulejsonview.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserDetails.class)
    private Long id;

    @JsonView(Views.UserDetails.class)
    @NotNull(message = "Order amount is required")
    private BigDecimal amount;

    @JsonView(Views.UserDetails.class)
    @NotEmpty(message = "Status is required")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(Long id, BigDecimal amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }
}
