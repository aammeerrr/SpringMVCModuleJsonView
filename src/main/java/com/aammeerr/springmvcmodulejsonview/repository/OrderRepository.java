package com.aammeerr.springmvcmodulejsonview.repository;

import com.aammeerr.springmvcmodulejsonview.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
