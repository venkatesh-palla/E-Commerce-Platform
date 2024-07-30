package com.example.E_Commerce_Platform.controller;

import com.example.E_Commerce_Platform.model.User;
import com.example.E_Commerce_Platform.model.Wishlist;
import com.example.E_Commerce_Platform.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Wishlist> getWishlistByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return wishlistService.getWishlistByUser(user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Wishlist> addToWishlist(@RequestBody Wishlist wishlist) {
        return ResponseEntity.ok(wishlistService.saveWishlist(wishlist));
    }
}

