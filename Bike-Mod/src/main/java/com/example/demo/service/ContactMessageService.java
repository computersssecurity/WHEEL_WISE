package com.example.demo.service;

import com.example.demo.entity.ContactMessage;
import com.example.demo.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this class as a service component in the Spring context
public class ContactMessageService {

    @Autowired
    private ContactMessageRepository contactMessageRepository; // Creating a object(or) reference for contact message repository

    // Method to save a contact message
    public ContactMessage saveContactMessage(ContactMessage contactMessage) {
        return contactMessageRepository.save(contactMessage); // Save and return the saved message
    }

    // Method to retrieve all contact messages
    public List<ContactMessage> getAllContactMessages() {
        return contactMessageRepository.findAll(); // Fetch and return the list of all messages
    }
}