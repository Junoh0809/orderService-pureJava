package org.example.controller;

import org.example.model.dto.OrderRequestDto;
import org.example.model.exception.OrderNotFoundException;
import org.example.model.repository.OrderRepository;
import org.example.model.repository.OrderRepositoryImpl;
import org.example.model.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderControllerTest {
    OrderRepository repository = new OrderRepositoryImpl();
    OrderService orderService = new OrderService(repository);

    @Test
    @DisplayName("주문 생성 성공 테스트")
    void createOrder() {
        // given
        OrderRequestDto request = OrderRequestDto.create("1", "1", "macbook-m1", 1);
        // when
        // then
        Assertions.assertEquals("1",  orderService.createOrder(request));
    }

    @Test
    @DisplayName("주문 생성 실패 테스트")
    void createOrderFail() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OrderRequestDto request = OrderRequestDto.create("1", "1", "macbook-m1", 0);
            orderService.createOrder(request);
        });
    }

    @Test
    @DisplayName("주문 취소 성공 테스트")
    void cancelOrderSuccess() {
        OrderRequestDto request = OrderRequestDto.create("1", "1", "macbook-m1", 1);
        orderService.createOrder(request);
        String orderId = "1";

        Assertions.assertEquals("1",  orderService.cancelOrder(orderId));
    }

    @Test
    @DisplayName("주문 취소 실패 테스트")
    void cancelOrderFail() {
        // gievn
        OrderRequestDto request = OrderRequestDto.create("1", "1", "macbook-m1", 1);
        orderService.createOrder(request);
        String orderId = "0";

        // when
        OrderNotFoundException result = Assertions.assertThrows(OrderNotFoundException.class, () -> {
            orderService.cancelOrder(orderId);
        });
        Assertions.assertEquals("주문을 찾을 수가 없습니다. orderId=0", result.getMessage());

    }
    
    @Test
    @DisplayName("주문 수정 테스트")
    void orderModification() {
        // gievn
        String orderId = "1";
        int quantity = 1;

        // when
        String testResult = orderService.setOrderQuentity(orderId, quantity);

        // then
        Assertions.assertEquals(orderId, testResult);
    }

    @Test
    @DisplayName("주문 수정 테스트")
    void orderSetQuantitySuccess() {
        // gievn
        OrderRequestDto request = OrderRequestDto.create("1", "1", "macbook-m1", 1);
        orderService.createOrder(request);
        String orderId = "1";
        int quantity = 3;
        // when

        // then
        Assertions.assertEquals("1", orderService.setOrderQuentity(orderId, quantity));
    }

    @Test
    @DisplayName("주문 수정 싪패 테스트")
    void orderSetQuantityFail() {
        // gievn
        OrderRequestDto request = OrderRequestDto.create("1", "1", "macbook-m1", 1);
        orderService.createOrder(request);
        String orderId = "0";
        int quntity = 3;

        // when
        // then
        OrderNotFoundException result = Assertions.assertThrows(OrderNotFoundException.class, () -> {
            orderService.setOrderQuentity(orderId, quntity);
        });
    }

}