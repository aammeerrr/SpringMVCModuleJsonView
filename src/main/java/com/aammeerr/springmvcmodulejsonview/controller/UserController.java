package com.aammeerr.springmvcmodulejsonview.controller;

import com.aammeerr.springmvcmodulejsonview.entity.User;
import com.aammeerr.springmvcmodulejsonview.jsonview.Views;
import com.aammeerr.springmvcmodulejsonview.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @JsonView(Views.UserSummary.class)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @JsonView(Views.UserDetails.class)
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
