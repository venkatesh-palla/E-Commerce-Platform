package com.example.E_Commerce_Platform.controller;

import com.example.E_Commerce_Platform.model.Cart;
import com.example.E_Commerce_Platform.model.User;
import com.example.E_Commerce_Platform.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return cartService.getCartByUser(user)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.saveCart(cart));
    }

    @DeleteMapping("/clear/{cartId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        Cart cart = new Cart();
        cart.setId(cartId);
        cartService.clearCart(cart);
        return ResponseEntity.noContent().build();
    }
}
