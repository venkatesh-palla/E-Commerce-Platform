package com.example.E_Commerce_Platform.repository;

import com.example.E_Commerce_Platform.model.User;
import com.example.E_Commerce_Platform.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByUser(User user);
}