package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Marks this class as a service component in the Spring context
public class UserService {

    @Autowired
    private UserRepository userRepository; // Creating a object(or) reference for user repository

    // Method to find a user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username); // Return user if found
    }

    // Method to find a user by email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email); // Return user if found
    }

    // Method to save a new user
    public User saveUser(User user) {
        return userRepository.save(user); // Save and return the saved user
    }
}