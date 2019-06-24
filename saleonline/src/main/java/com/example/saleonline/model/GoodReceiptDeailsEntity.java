package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GoodReceiptDeails", schema = "SaleOnline", catalog = "")
@IdClass(GoodReceiptDeailsEntityPK.class)
public class GoodReceiptDeailsEntity {
    private int receiptId;
    private int receiptProductId;
    private Integer receiptQuantity;
    private Double receiptUnitPrice;

    @Id
    @Column(name = "receipt_Id")
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    @Id
    @Column(name = "receipt_ProductId")
    public int getReceiptProductId() {
        return receiptProductId;
    }

    public void setReceiptProductId(int receiptProductId) {
        this.receiptProductId = receiptProductId;
    }

    @Basic
    @Column(name = "receipt_Quantity")
    public Integer getReceiptQuantity() {
        return receiptQuantity;
    }

    public void setReceiptQuantity(Integer receiptQuantity) {
        this.receiptQuantity = receiptQuantity;
    }

    @Basic
    @Column(name = "receipt_UnitPrice")
    public Double getReceiptUnitPrice() {
        return receiptUnitPrice;
    }

    public void setReceiptUnitPrice(Double receiptUnitPrice) {
        this.receiptUnitPrice = receiptUnitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodReceiptDeailsEntity that = (GoodReceiptDeailsEntity) o;
        return receiptId == that.receiptId &&
                receiptProductId == that.receiptProductId &&
                Objects.equals(receiptQuantity, that.receiptQuantity) &&
                Objects.equals(receiptUnitPrice, that.receiptUnitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, receiptProductId, receiptQuantity, receiptUnitPrice);
    }
}
