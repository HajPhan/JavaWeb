package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Producers", schema = "SaleOnline", catalog = "")
public class ProducersEntity {
    private int producerId;
    private String producerName;
    private String producerCountry;
    private String producerLogo;
    private Boolean producerStatus;

    @Id
    @Column(name = "producer_ID")
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "producer_Name")
    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    @Basic
    @Column(name = "producer_Country")
    public String getProducerCountry() {
        return producerCountry;
    }

    public void setProducerCountry(String producerCountry) {
        this.producerCountry = producerCountry;
    }

    @Basic
    @Column(name = "producer_Logo")
    public String getProducerLogo() {
        return producerLogo;
    }

    public void setProducerLogo(String producerLogo) {
        this.producerLogo = producerLogo;
    }

    @Basic
    @Column(name = "producer_Status")
    public Boolean getProducerStatus() {
        return producerStatus;
    }

    public void setProducerStatus(Boolean producerStatus) {
        this.producerStatus = producerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducersEntity that = (ProducersEntity) o;
        return producerId == that.producerId &&
                Objects.equals(producerName, that.producerName) &&
                Objects.equals(producerCountry, that.producerCountry) &&
                Objects.equals(producerLogo, that.producerLogo) &&
                Objects.equals(producerStatus, that.producerStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producerId, producerName, producerCountry, producerLogo, producerStatus);
    }
}
