package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api") // Base URL for user-related endpoints
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.POST, RequestMethod.GET}, allowedHeaders = "*") // Allow CORS for specific origin
public class UserController {

    @Autowired
    private UserService userService; 

    // Endpoint for user sign-up
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        // Check if the username already exists
        Optional<User> existingUser = userService.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(409).body("Username already taken"); // Conflict status
        }
        // Check if the email is already registered
        Optional<User> existingEmail = userService.findByEmail(user.getEmail());
        if (existingEmail.isPresent()) {
            return ResponseEntity.status(409).body("Email already registered"); // Conflict status
        }
        // Save the new user
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully"); // Success response
    }

    // Endpoint for user sign-in
    @PostMapping("/signin")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        // Retrieve user by username
        User existingUser = userService.findByUsername(user.getUsername()).orElse(null);
        // Validate password
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            existingUser.setPassword(null); // Remove password from response for security
            return ResponseEntity.ok(existingUser); // Return user details on successful sign-in
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized status for failed sign-in
        }
    }
}