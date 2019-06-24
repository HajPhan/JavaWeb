package com.example.saleonline.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "GoodReceipts", schema = "SaleOnline", catalog = "")
public class GoodReceiptsEntity {
    private int receiptId;
    private Integer receiptEmployeeId;
    private Integer receiptSupplierId;
    private Timestamp receiptDate;
    private Boolean receiptStatus;

    @Id
    @Column(name = "receipt_Id")
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    @Basic
    @Column(name = "receipt_EmployeeId")
    public Integer getReceiptEmployeeId() {
        return receiptEmployeeId;
    }

    public void setReceiptEmployeeId(Integer receiptEmployeeId) {
        this.receiptEmployeeId = receiptEmployeeId;
    }

    @Basic
    @Column(name = "receipt_SupplierId")
    public Integer getReceiptSupplierId() {
        return receiptSupplierId;
    }

    public void setReceiptSupplierId(Integer receiptSupplierId) {
        this.receiptSupplierId = receiptSupplierId;
    }

    @Basic
    @Column(name = "receipt_Date")
    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Basic
    @Column(name = "receipt_Status")
    public Boolean getReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(Boolean receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodReceiptsEntity that = (GoodReceiptsEntity) o;
        return receiptId == that.receiptId &&
                Objects.equals(receiptEmployeeId, that.receiptEmployeeId) &&
                Objects.equals(receiptSupplierId, that.receiptSupplierId) &&
                Objects.equals(receiptDate, that.receiptDate) &&
                Objects.equals(receiptStatus, that.receiptStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiptId, receiptEmployeeId, receiptSupplierId, receiptDate, receiptStatus);
    }
}
