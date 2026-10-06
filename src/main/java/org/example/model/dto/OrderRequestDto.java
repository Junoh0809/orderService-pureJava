package org.example.model.dto;

public class OrderRequestDto {
    private final String orderId;
    private final String productId;
    private final String productName;
    private final int quantity;

    private OrderRequestDto(String orderId, String productId, String productName, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public static OrderRequestDto create(String orderId, String productId, String productName, int quantity) {
        // 유효성 검증
        if (orderId == null || productId == null || productName == null) {
            throw new NullPointerException("orderId, productId, productName은 Null이면 안됩니다.");
        }

        if (orderId.isBlank() || productId.isBlank() || productName.isBlank()) {
            throw new IllegalArgumentException("orderId, productId, productName은 빈문자열이면 안됩니다.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("주문량은 한개 이상이여 합니다");
        }
        return new OrderRequestDto(orderId, productId, productName, quantity);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}
