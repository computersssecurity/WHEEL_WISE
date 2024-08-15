package com.example.demo.service;

import com.example.demo.entity.CartItem;
import com.example.demo.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    // Method to add an item to the cart
    public CartItem addItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    // Method to remove an item from the cart
    public void removeItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    // Method to update an item in the cart
    public CartItem updateItem(Long id, CartItem updatedItem) {
        updatedItem.setId(id);
        return cartItemRepository.save(updatedItem);
    }

    // Method to get all items in the cart for a specific user
    public List<CartItem> getCartItems(Long userId) {
        return cartItemRepository.findByUserId(userId);
    }
}
