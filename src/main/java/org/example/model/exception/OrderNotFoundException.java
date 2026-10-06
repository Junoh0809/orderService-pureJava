package org.example.model.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String orderId) {
        super("주문을 찾을 수가 없습니다. orderId="+ orderId);
    }
}
