package org.example.controller;

import org.example.model.dto.OrderRequestDto;
import org.example.model.repository.OrderRepository;
import org.example.model.repository.OrderRepositoryImpl;
import org.example.model.service.OrderService;

// 컨트롤러에서는 인자를 각각 받아서 넘기고 서비스에서 order를 생성
public class OrderController {
    private final OrderRepository orderRepository = new OrderRepositoryImpl();
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public String createOrder(OrderRequestDto request) {
        orderService.createOrder(request);
        return "주문 성공";
    }

    public String cancelOrder(String orderId) {
        orderService.cancelOrder(orderId);
        return "취소 성공";
    }

    public String updateOrder(String orderId, int quantity) {
        orderService.setOrderQuentity(orderId, quantity);
        return "주무량 수정 성공";
    }
}