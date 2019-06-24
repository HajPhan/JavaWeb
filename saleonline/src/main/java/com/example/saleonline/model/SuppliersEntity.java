package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Suppliers", schema = "SaleOnline", catalog = "")
public class SuppliersEntity {
    private int supplierId;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;
    private Boolean supplierStatus;

    @Id
    @Column(name = "supplier_Id")
    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "supplier_Name")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "supplier_Address")
    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    @Basic
    @Column(name = "supplier_Phone")
    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    @Basic
    @Column(name = "supplier_Status")
    public Boolean getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierStatus(Boolean supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuppliersEntity that = (SuppliersEntity) o;
        return supplierId == that.supplierId &&
                Objects.equals(supplierName, that.supplierName) &&
                Objects.equals(supplierAddress, that.supplierAddress) &&
                Objects.equals(supplierPhone, that.supplierPhone) &&
                Objects.equals(supplierStatus, that.supplierStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, supplierAddress, supplierPhone, supplierStatus);
    }
}
