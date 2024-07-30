package com.example.E_Commerce_Platform.controller;

import com.example.E_Commerce_Platform.model.Coupon;
import com.example.E_Commerce_Platform.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/{code}")
    public ResponseEntity<Coupon> getCouponByCode(@PathVariable String code) {
        return couponService.getCouponByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
        return ResponseEntity.ok(couponService.saveCoupon(coupon));
    }
}

