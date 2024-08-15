package com.example.demo.repository;

import com.example.demo.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for managing ContactMessage entities
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    // Inherits CRUD operations for this from JpaRepository
    
}