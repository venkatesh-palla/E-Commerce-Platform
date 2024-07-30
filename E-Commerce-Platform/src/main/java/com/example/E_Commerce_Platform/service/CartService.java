package com.example.E_Commerce_Platform.service;

import com.example.E_Commerce_Platform.model.Cart;
import com.example.E_Commerce_Platform.model.User;
import com.example.E_Commerce_Platform.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Optional<Cart> getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void clearCart(Cart cart) {
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }
}

