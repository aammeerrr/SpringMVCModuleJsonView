package com.aammeerr.springmvcmodulejsonview.repository;

import com.aammeerr.springmvcmodulejsonview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
