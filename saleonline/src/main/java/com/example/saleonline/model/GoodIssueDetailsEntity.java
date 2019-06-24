package com.example.saleonline.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GoodIssueDetails", schema = "SaleOnline", catalog = "")
@IdClass(GoodIssueDetailsEntityPK.class)
public class GoodIssueDetailsEntity {
    private int issueId;
    private int issueProducId;
    private Integer issueQuantity;
    private Double issueUnitPrice;
    private Double issueTotalPrice;
    private Boolean issueStatus;

    @Id
    @Column(name = "issue_Id")
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Id
    @Column(name = "issue_ProducId")
    public int getIssueProducId() {
        return issueProducId;
    }

    public void setIssueProducId(int issueProducId) {
        this.issueProducId = issueProducId;
    }

    @Basic
    @Column(name = "issue_Quantity")
    public Integer getIssueQuantity() {
        return issueQuantity;
    }

    public void setIssueQuantity(Integer issueQuantity) {
        this.issueQuantity = issueQuantity;
    }

    @Basic
    @Column(name = "issue_UnitPrice")
    public Double getIssueUnitPrice() {
        return issueUnitPrice;
    }

    public void setIssueUnitPrice(Double issueUnitPrice) {
        this.issueUnitPrice = issueUnitPrice;
    }

    @Basic
    @Column(name = "issue_TotalPrice")
    public Double getIssueTotalPrice() {
        return issueTotalPrice;
    }

    public void setIssueTotalPrice(Double issueTotalPrice) {
        this.issueTotalPrice = issueTotalPrice;
    }

    @Basic
    @Column(name = "issue_Status")
    public Boolean getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(Boolean issueStatus) {
        this.issueStatus = issueStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodIssueDetailsEntity that = (GoodIssueDetailsEntity) o;
        return issueId == that.issueId &&
                issueProducId == that.issueProducId &&
                Objects.equals(issueQuantity, that.issueQuantity) &&
                Objects.equals(issueUnitPrice, that.issueUnitPrice) &&
                Objects.equals(issueTotalPrice, that.issueTotalPrice) &&
                Objects.equals(issueStatus, that.issueStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, issueProducId, issueQuantity, issueUnitPrice, issueTotalPrice, issueStatus);
    }
}
