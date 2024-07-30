package com.example.E_Commerce_Platform.service;

import com.example.E_Commerce_Platform.model.User;
import com.example.E_Commerce_Platform.model.Wishlist;
import com.example.E_Commerce_Platform.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;

    public Optional<Wishlist> getWishlistByUser(User user) {
        return wishlistRepository.findByUser(user);
    }

    public Wishlist saveWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }
}

