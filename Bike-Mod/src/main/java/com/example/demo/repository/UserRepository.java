package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository interface for managing User entities
public interface UserRepository extends JpaRepository<User, Long> {
    // Inherits CRUD operations for this from JpaRepository
    
    // Custom method to find a user by username
    Optional<User> findByUsername(String username);
    
    // Custom method to find a user by email
    Optional<User> findByEmail(String email);
}