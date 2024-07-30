package com.example.E_Commerce_Platform.service;

import com.example.E_Commerce_Platform.model.Payment;
import com.example.E_Commerce_Platform.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }


}
