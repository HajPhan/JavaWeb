package com.example.saleonline.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Customers", schema = "SaleOnline", catalog = "")
public class CustomersEntity {
    private int customerId;
    private String customerFullName;
    private Date customerDateBirth;
    private String customerSex;
    private String customerPhone;
    private String customerMail;
    private String customerAddress;
    private Timestamp customerDateRegister;
    private Boolean customerStatus;

    @Id
    @Column(name = "customer_Id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "customer_FullName")
    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    @Basic
    @Column(name = "customer_DateBirth")
    public Date getCustomerDateBirth() {
        return customerDateBirth;
    }

    public void setCustomerDateBirth(Date customerDateBirth) {
        this.customerDateBirth = customerDateBirth;
    }

    @Basic
    @Column(name = "customer_Sex")
    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    @Basic
    @Column(name = "customer_Phone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "customer_Mail")
    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    @Basic
    @Column(name = "customer_Address")
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Basic
    @Column(name = "customer_DateRegister")
    public Timestamp getCustomerDateRegister() {
        return customerDateRegister;
    }

    public void setCustomerDateRegister(Timestamp customerDateRegister) {
        this.customerDateRegister = customerDateRegister;
    }

    @Basic
    @Column(name = "customer_Status")
    public Boolean getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Boolean customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersEntity that = (CustomersEntity) o;
        return customerId == that.customerId &&
                Objects.equals(customerFullName, that.customerFullName) &&
                Objects.equals(customerDateBirth, that.customerDateBirth) &&
                Objects.equals(customerSex, that.customerSex) &&
                Objects.equals(customerPhone, that.customerPhone) &&
                Objects.equals(customerMail, that.customerMail) &&
                Objects.equals(customerAddress, that.customerAddress) &&
                Objects.equals(customerDateRegister, that.customerDateRegister) &&
                Objects.equals(customerStatus, that.customerStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerFullName, customerDateBirth, customerSex, customerPhone, customerMail, customerAddress, customerDateRegister, customerStatus);
    }
}
