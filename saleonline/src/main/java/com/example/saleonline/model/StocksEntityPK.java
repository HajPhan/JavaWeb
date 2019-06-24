package com.example.saleonline.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class StocksEntityPK implements Serializable {
    private Date stockDate;
    private int stockProducId;

    @Column(name = "stock_Date")
    @Id
    public Date getStockDate() {
        return stockDate;
    }

    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }

    @Column(name = "stock_ProducId")
    @Id
    public int getStockProducId() {
        return stockProducId;
    }

    public void setStockProducId(int stockProducId) {
        this.stockProducId = stockProducId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StocksEntityPK that = (StocksEntityPK) o;
        return stockProducId == that.stockProducId &&
                Objects.equals(stockDate, that.stockDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockDate, stockProducId);
    }
}
