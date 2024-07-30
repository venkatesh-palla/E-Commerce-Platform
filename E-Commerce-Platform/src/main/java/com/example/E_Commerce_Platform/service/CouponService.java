package com.example.E_Commerce_Platform.service;

import com.example.E_Commerce_Platform.model.Coupon;
import com.example.E_Commerce_Platform.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    public Optional<Coupon> getCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }

    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }
}
