package org.example.model.repository;

import org.example.model.entity.Order;

public interface OrderRepository {
    Order save(Order order);
    boolean orderCancel(String orderId);
    String findById(String orderId);
    boolean setQuantity(String orderId, int quantity);
}
