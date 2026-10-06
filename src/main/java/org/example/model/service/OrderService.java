package org.example.model.service;

import org.example.model.dto.OrderRequestDto;
import org.example.model.entity.Order;
import org.example.model.exception.OrderNotFoundException;
import org.example.model.repository.OrderRepository;

public class OrderService {
    // 주문이 할 수 있는 행동을 정의를 해야한다

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String createOrder(OrderRequestDto request) {
        // service -> repository로 order를 넘겨줌
        Order order = Order.createOrder(request);
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }

    // 주문 취소(전체 취소)
    public String cancelOrder(String orderId) {
        if (orderId.equalsIgnoreCase(orderRepository.findById(orderId))) {
            orderRepository.orderCancel(orderId);
            return orderId;
        } else {
            throw new OrderNotFoundException(orderId);
        }
    }


    // 주문 수정
    public String setOrderQuentity(String orderId, int quentity) {
        if (orderRepository.findById(orderId).equalsIgnoreCase(orderId)) {
            orderRepository.setQuantity(orderId, quentity);
        } else {
            throw new OrderNotFoundException(orderId);
        }
        return orderId;
    }



}
