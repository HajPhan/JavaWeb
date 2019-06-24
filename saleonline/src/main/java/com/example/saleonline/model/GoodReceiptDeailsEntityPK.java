package com.example.saleonline.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodReceiptDeailsEntityPK implements Serializable {
    private int receiptId;
    private int receiptProductId;

    @Column(name = "receipt_Id")
    @Id
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    @Column(name = "receipt_ProductId")
    @Id
    public int getReceiptProductId() {
        return receiptProductId;
    }

    public void setReceiptProductId(int receiptProductId) {
        this.receiptProductId = receiptProductId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodReceiptDeailsEntityPK that = (GoodReceiptDeailsEntityPK) o;
        return receiptId == that.receiptId &&
                receiptProductId == that.receiptProductId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, receiptProductId);
    }
}
