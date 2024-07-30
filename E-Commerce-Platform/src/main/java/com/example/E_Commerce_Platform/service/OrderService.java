package com.example.E_Commerce_Platform.service;

import com.example.E_Commerce_Platform.enums.OrderStatus;
import com.example.E_Commerce_Platform.model.Order;
import com.example.E_Commerce_Platform.model.User;
import com.example.E_Commerce_Platform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getUser().equals(user))
                .collect(Collectors.toList());
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> updateOrderStatus(Long orderId, OrderStatus status) {
        return orderRepository.findById(orderId).map(order -> {
            order.setStatus(status);
            return orderRepository.save(order);
        });
    }
}
