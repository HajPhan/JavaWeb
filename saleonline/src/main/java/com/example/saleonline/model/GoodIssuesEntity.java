package com.example.saleonline.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "GoodIssues", schema = "SaleOnline", catalog = "")
public class GoodIssuesEntity {
    private int issueId;
    private Integer issueEmployeeId;
    private Integer issueCustomerId;
    private Integer issueOrderId;
    private Timestamp issueDate;
    private Boolean issueStatus;

    @Id
    @Column(name = "issue_Id")
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Basic
    @Column(name = "issue_EmployeeId")
    public Integer getIssueEmployeeId() {
        return issueEmployeeId;
    }

    public void setIssueEmployeeId(Integer issueEmployeeId) {
        this.issueEmployeeId = issueEmployeeId;
    }

    @Basic
    @Column(name = "issue_CustomerId")
    public Integer getIssueCustomerId() {
        return issueCustomerId;
    }

    public void setIssueCustomerId(Integer issueCustomerId) {
        this.issueCustomerId = issueCustomerId;
    }

    @Basic
    @Column(name = "issue_OrderId")
    public Integer getIssueOrderId() {
        return issueOrderId;
    }

    public void setIssueOrderId(Integer issueOrderId) {
        this.issueOrderId = issueOrderId;
    }

    @Basic
    @Column(name = "issue_Date")
    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
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
        GoodIssuesEntity that = (GoodIssuesEntity) o;
        return issueId == that.issueId &&
                Objects.equals(issueEmployeeId, that.issueEmployeeId) &&
                Objects.equals(issueCustomerId, that.issueCustomerId) &&
                Objects.equals(issueOrderId, that.issueOrderId) &&
                Objects.equals(issueDate, that.issueDate) &&
                Objects.equals(issueStatus, that.issueStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, issueEmployeeId, issueCustomerId, issueOrderId, issueDate, issueStatus);
    }
}
