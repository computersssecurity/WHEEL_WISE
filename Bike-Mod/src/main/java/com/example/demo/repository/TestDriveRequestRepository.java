package com.example.demo.repository;

import com.example.demo.entity.TestDriveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for managing TestDriveRequest entities
@Repository // Marks this interface as a Spring repository component
public interface TestDriveRequestRepository extends JpaRepository<TestDriveRequest, Long> {
    // Inherits CRUD operations for this from JpaRepository
  
}