package org.example.model.entity;

import org.example.model.DeriveryStatus;
import org.example.model.dto.OrderRequestDto;

public class Order {
    private String orderId;
    private String productId;
    private String productName;
    private int quantity;
    private DeriveryStatus status;

    private Order(String orderId, String productId, String productName, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.status = DeriveryStatus.BEFORE_DELIVERY;
    }

    public static Order createOrder(OrderRequestDto request) {
        return new Order(request.getOrderId(), request.getProductId(), request.getProductName(), request.getQuantity());
    }

    @Override
    public boolean equals(Object order) {
        Order orderTmp = (Order)order;
        return orderTmp.getOrderId().equals(this.orderId) &&
                orderTmp.getProductId().equals(this.productId) &&
                orderTmp.getProductName().equals(this.productName) &&
                orderTmp.getQuantity() == this.quantity &&
                orderTmp.getStatus().equals(this.status);
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

    public DeriveryStatus getStatus() {
        return status;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void changeStatus(DeriveryStatus status) {
        this.status = status;
    }
}
