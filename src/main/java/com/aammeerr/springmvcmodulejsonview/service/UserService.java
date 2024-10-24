package com.aammeerr.springmvcmodulejsonview.service;

import com.aammeerr.springmvcmodulejsonview.entity.User;
import com.aammeerr.springmvcmodulejsonview.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + "not found"));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + "not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        User user = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("User with id " + id + "not found"));
        repository.delete(user);
    }
}
