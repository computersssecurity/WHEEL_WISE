package com.example.demo.controller;

import com.example.demo.entity.TestDriveRequest;
import com.example.demo.service.TestDriveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Allow cross-origin requests from any domain
@CrossOrigin("*")
@RestController
@RequestMapping("/api/testdrive") // Base URL for test drive requests
public class TestDriveRequestController {

    @Autowired
    private TestDriveRequestService testDriveRequestService; 

    // Endpoint to create a new test drive request
    @PostMapping
    public ResponseEntity<TestDriveRequest> createRequest(@RequestBody TestDriveRequest request) {
        // Save the request and return the saved entity
        TestDriveRequest savedRequest = testDriveRequestService.saveRequest(request);
        return ResponseEntity.ok(savedRequest); // Return the saved request with a 200 OK status
    }

    // Endpoint to retrieve all test drive requests
    @GetMapping
    public ResponseEntity<List<TestDriveRequest>> getAllRequests() {
        // Fetch all requests from the service
        List<TestDriveRequest> requests = testDriveRequestService.getAllRequests();
        return ResponseEntity.ok(requests); // Return the list of requests with a 200 OK status
    }
}