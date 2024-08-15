package com.example.demo.service;

import com.example.demo.entity.TestDriveRequest;
import com.example.demo.repository.TestDriveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a service component in the Spring context
public class TestDriveRequestService {

    @Autowired
    private TestDriveRequestRepository testDriveRequestRepository; // Creating a object(or) reference for test drive request repository

    // Method to save a test drive request
    public TestDriveRequest saveRequest(TestDriveRequest request) {
        return testDriveRequestRepository.save(request); // Save and return the saved request
    }

    // Method to retrieve all test drive requests
    public List<TestDriveRequest> getAllRequests() {
        return testDriveRequestRepository.findAll(); // Fetch and return the list of all requests
    }
}