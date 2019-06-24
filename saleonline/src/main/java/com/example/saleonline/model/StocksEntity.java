package com.example.saleonline.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Stocks", schema = "SaleOnline", catalog = "")
@IdClass(StocksEntityPK.class)
public class StocksEntity {
    private Date stockDate;
    private int stockProducId;
    private Integer stockTotalOriginal;
    private Integer stockTotalReceipt;
    private Integer stockTotalIssue;
    private Double stockTotalRemain;
    private Boolean stockStatus;

    @Id
    @Column(name = "stock_Date")
    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    @Id
    @Column(name = "stock_ProducId")
    public int getStockProducId() {
        return stockProducId;
    }

    public void setStockProducId(int stockProducId) {
        this.stockProducId = stockProducId;
    }

    @Basic
    @Column(name = "stock_TotalOriginal")
    public Integer getStockTotalOriginal() {
        return stockTotalOriginal;
    }

    public void setStockTotalOriginal(Integer stockTotalOriginal) {
        this.stockTotalOriginal = stockTotalOriginal;
    }

    @Basic
    @Column(name = "stock_TotalReceipt")
    public Integer getStockTotalReceipt() {
        return stockTotalReceipt;
    }

    public void setStockTotalReceipt(Integer stockTotalReceipt) {
        this.stockTotalReceipt = stockTotalReceipt;
    }

    @Basic
    @Column(name = "stock_TotalIssue")
    public Integer getStockTotalIssue() {
        return stockTotalIssue;
    }

    public void setStockTotalIssue(Integer stockTotalIssue) {
        this.stockTotalIssue = stockTotalIssue;
    }

    @Basic
    @Column(name = "stock_TotalRemain")
    public Double getStockTotalRemain() {
        return stockTotalRemain;
    }

    public void setStockTotalRemain(Double stockTotalRemain) {
        this.stockTotalRemain = stockTotalRemain;
    }

    @Basic
    @Column(name = "stock_Status")
    public Boolean getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Boolean stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StocksEntity that = (StocksEntity) o;
        return stockProducId == that.stockProducId &&
                Objects.equals(stockDate, that.stockDate) &&
                Objects.equals(stockTotalOriginal, that.stockTotalOriginal) &&
                Objects.equals(stockTotalReceipt, that.stockTotalReceipt) &&
                Objects.equals(stockTotalIssue, that.stockTotalIssue) &&
                Objects.equals(stockTotalRemain, that.stockTotalRemain) &&
                Objects.equals(stockStatus, that.stockStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockDate, stockProducId, stockTotalOriginal, stockTotalReceipt, stockTotalIssue, stockTotalRemain, stockStatus);
    }
}
