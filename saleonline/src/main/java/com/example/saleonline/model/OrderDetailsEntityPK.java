package com.example.saleonline.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderDetailsEntityPK implements Serializable {
    private int orderId;
    private int orderProductId;

    @Column(name = "order_Id")
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "order_ProductId")
    @Id
    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailsEntityPK that = (OrderDetailsEntityPK) o;
        return orderId == that.orderId &&
                orderProductId == that.orderProductId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderProductId);
    }
}
