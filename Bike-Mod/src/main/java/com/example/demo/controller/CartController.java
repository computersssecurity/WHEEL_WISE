package com.example.demo.controller;

import com.example.demo.entity.CartItem;
import com.example.demo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/cart") // Base URL for cart-related endpoints
@CrossOrigin(origins = "http://localhost:3000") // Allow CORS for specific origin
public class CartController {

    @Autowired
    private CartService cartService;

    // Endpoint to add an item to the cart
    @PostMapping("/add")
    public ResponseEntity<CartItem> addToCart(@RequestParam("productName") String productName,
                                              @RequestParam("quantity") int quantity,
                                              @RequestParam("price") double price,
                                              @RequestParam("userId") Long userId,
                                              @RequestParam(value = "image", required = false) MultipartFile image) {
        CartItem cartItem = new CartItem();
        cartItem.setProductName(productName);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(price);
        cartItem.setUserId(userId);

        try {
            if (image != null && !image.isEmpty()) {
                cartItem.setImage(image.getBytes());
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null); // Internal Server Error
        }

        CartItem savedItem = cartService.addItem(cartItem);
        return ResponseEntity.ok(savedItem);
    }

    // Endpoint to remove an item from the cart
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Void> removeFromCart(@PathVariable Long id) {
        cartService.removeItem(id);
        return ResponseEntity.noContent().build(); // No content response
    }

    // Endpoint to update an item in the cart
    @PutMapping("/update/{id}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedItem) {
        CartItem item = cartService.updateItem(id, updatedItem);
        return ResponseEntity.ok(item);
    }

    // Endpoint to get all cart items for a user
    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long userId) {
        List<CartItem> items = cartService.getCartItems(userId);
        return ResponseEntity.ok(items);
    }
}
