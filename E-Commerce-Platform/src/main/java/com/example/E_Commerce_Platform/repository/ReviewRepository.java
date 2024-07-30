package com.example.E_Commerce_Platform.repository;

import com.example.E_Commerce_Platform.model.Product;
import com.example.E_Commerce_Platform.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
    List<Review> findByProductId(Long productId);
}