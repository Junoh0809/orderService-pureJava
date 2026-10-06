package org.example.model.repository;

import org.example.model.DeriveryStatus;
import org.example.model.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderRepositoryImpl implements OrderRepository {
    List<Order> orderList = new ArrayList<>(); // DB 대체

    @Override
    public Order save(Order order) {
        Logger log = Logger.getLogger(OrderRepositoryImpl.class.getName());
        log.log(Level.INFO, "주문 저장 완료"); // 어디에 저장되는지?

        String sql = "INSERT INTO order (orderId, productId, productName, quantity, status) VALUES ('"
                + order.getOrderId() + ','
                + order.getProductId() + ','
                + order.getProductName() + ','
                + order.getQuantity() + ','
                + DeriveryStatus.BEFORE_DELIVERY +
                "');";
        orderList.add(order);
        return order;
    }

    @Override
    public boolean orderCancel(String orderId) {
        String sql = "UPDATE order SET status = 'CANCELLED' WHERE orderId = '";

        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                order.changeStatus(DeriveryStatus.CANCELLED);
            }
        }

        return true;
    }

    @Override
    public String findById(String orderId) {
        String sql = "SELECT * FROM order WHERE orderId = '" + orderId + "'";
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                return order.getOrderId();
            }
        }
        return null;
    }

    @Override
    public boolean setQuantity(String orderId, int quantity) {
        String sql = "UPDATE order SET quantity = '" + quantity + "' WHERE orderId = '";
        for (Order order : orderList) {
            if (order.getOrderId().equals(orderId)) {
                order.setQuantity(quantity);
            }
        }
        return true;
    }
}
