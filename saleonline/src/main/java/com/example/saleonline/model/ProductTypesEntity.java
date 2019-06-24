package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ProductTypes", schema = "SaleOnline", catalog = "")
public class ProductTypesEntity {
    private int productypeId;
    private String productypeName;
    private String productypeUnit;
    private Boolean productypeStatus;

    @Id
    @Column(name = "productype_Id")
    public int getProductypeId() {
        return productypeId;
    }

    public void setProductypeId(int productypeId) {
        this.productypeId = productypeId;
    }

    @Basic
    @Column(name = "productype_name")
    public String getProductypeName() {
        return productypeName;
    }

    public void setProductypeName(String productypeName) {
        this.productypeName = productypeName;
    }

    @Basic
    @Column(name = "productype_Unit")
    public String getProductypeUnit() {
        return productypeUnit;
    }

    public void setProductypeUnit(String productypeUnit) {
        this.productypeUnit = productypeUnit;
    }

    @Basic
    @Column(name = "productype_Status")
    public Boolean getProductypeStatus() {
        return productypeStatus;
    }

    public void setProductypeStatus(Boolean productypeStatus) {
        this.productypeStatus = productypeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTypesEntity that = (ProductTypesEntity) o;
        return productypeId == that.productypeId &&
                Objects.equals(productypeName, that.productypeName) &&
                Objects.equals(productypeUnit, that.productypeUnit) &&
                Objects.equals(productypeStatus, that.productypeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productypeId, productypeName, productypeUnit, productypeStatus);
    }
}
