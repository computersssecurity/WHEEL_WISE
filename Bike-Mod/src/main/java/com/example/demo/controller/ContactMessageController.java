package com.example.demo.controller;

import com.example.demo.entity.ContactMessage;
import com.example.demo.service.ContactMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // Base URL for contact message endpoints
@CrossOrigin(origins = "http://localhost:3000") // Allow CORS for the specified origin
public class ContactMessageController {

    @Autowired
    private ContactMessageService contactMessageService; 

    // Endpoint to send a contact message
    @PostMapping("/contact")
    public ResponseEntity<String> sendMessage(@RequestBody ContactMessage contactMessage) {
        contactMessageService.saveContactMessage(contactMessage); // Save the contact message
        return ResponseEntity.ok("Message sent successfully"); // Return success response
    }

    // Endpoint to retrieve all contact messages
    @GetMapping("/contact")
    public ResponseEntity<List<ContactMessage>> getAllMessages() {
        List<ContactMessage> messages = contactMessageService.getAllContactMessages(); // Fetch all messages
        return ResponseEntity.ok(messages); // Return the list of messages
    }
}