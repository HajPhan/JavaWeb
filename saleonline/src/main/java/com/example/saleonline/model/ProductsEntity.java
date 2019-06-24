package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Products", schema = "SaleOnline", catalog = "")
public class ProductsEntity {
    private int productId;
    private String productName;
    private Integer productProducerId;
    private Integer productProductTypeId;
    private String productImages;
    private Boolean prudoctStatus;

    @Id
    @Column(name = "product_Id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_Name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_ProducerId")
    public Integer getProductProducerId() {
        return productProducerId;
    }

    public void setProductProducerId(Integer productProducerId) {
        this.productProducerId = productProducerId;
    }

    @Basic
    @Column(name = "product_ProductTypeId")
    public Integer getProductProductTypeId() {
        return productProductTypeId;
    }

    public void setProductProductTypeId(Integer productProductTypeId) {
        this.productProductTypeId = productProductTypeId;
    }

    @Basic
    @Column(name = "product_Images")
    public String getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    @Basic
    @Column(name = "prudoct_Status")
    public Boolean getPrudoctStatus() {
        return prudoctStatus;
    }

    public void setPrudoctStatus(Boolean prudoctStatus) {
        this.prudoctStatus = prudoctStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsEntity that = (ProductsEntity) o;
        return productId == that.productId &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productProducerId, that.productProducerId) &&
                Objects.equals(productProductTypeId, that.productProductTypeId) &&
                Objects.equals(productImages, that.productImages) &&
                Objects.equals(prudoctStatus, that.prudoctStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productProducerId, productProductTypeId, productImages, prudoctStatus);
    }
}
