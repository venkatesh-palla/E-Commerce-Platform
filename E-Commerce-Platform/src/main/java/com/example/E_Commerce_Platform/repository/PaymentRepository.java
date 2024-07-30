package com.example.E_Commerce_Platform.repository;

import com.example.E_Commerce_Platform.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}