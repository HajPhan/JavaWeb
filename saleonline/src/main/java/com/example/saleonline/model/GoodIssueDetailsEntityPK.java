package com.example.saleonline.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodIssueDetailsEntityPK implements Serializable {
    private int issueId;
    private int issueProducId;

    @Column(name = "issue_Id")
    @Id
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Column(name = "issue_ProducId")
    @Id
    public int getIssueProducId() {
        return issueProducId;
    }

    public void setIssueProducId(int issueProducId) {
        this.issueProducId = issueProducId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodIssueDetailsEntityPK that = (GoodIssueDetailsEntityPK) o;
        return issueId == that.issueId &&
                issueProducId == that.issueProducId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId, issueProducId);
    }
}
