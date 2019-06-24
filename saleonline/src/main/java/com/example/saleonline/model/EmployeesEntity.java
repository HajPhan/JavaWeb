package com.example.saleonline.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Employees", schema = "SaleOnline", catalog = "")
public class EmployeesEntity {
    private int employeeId;
    private String employeeFullName;
    private Date employeeDateBirth;
    private String employeeSex;
    private String employeePhone;
    private String employeeMail;
    private String employeeAddress;
    private Timestamp employeeDateWork;
    private String employeeImages;
    private Boolean employeeStatus;

    @Id
    @Column(name = "employee_Id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_FullName")
    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    @Basic
    @Column(name = "employee_DateBirth")
    public Date getEmployeeDateBirth() {
        return employeeDateBirth;
    }

    public void setEmployeeDateBirth(Date employeeDateBirth) {
        this.employeeDateBirth = employeeDateBirth;
    }

    @Basic
    @Column(name = "employee_Sex")
    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    @Basic
    @Column(name = "employee_Phone")
    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    @Basic
    @Column(name = "employee_Mail")
    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    @Basic
    @Column(name = "employee_Address")
    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    @Basic
    @Column(name = "employee_DateWork")
    public Timestamp getEmployeeDateWork() {
        return employeeDateWork;
    }

    public void setEmployeeDateWork(Timestamp employeeDateWork) {
        this.employeeDateWork = employeeDateWork;
    }

    @Basic
    @Column(name = "employee_Images")
    public String getEmployeeImages() {
        return employeeImages;
    }

    public void setEmployeeImages(String employeeImages) {
        this.employeeImages = employeeImages;
    }

    @Basic
    @Column(name = "employee_Status")
    public Boolean getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeesEntity that = (EmployeesEntity) o;
        return employeeId == that.employeeId &&
                Objects.equals(employeeFullName, that.employeeFullName) &&
                Objects.equals(employeeDateBirth, that.employeeDateBirth) &&
                Objects.equals(employeeSex, that.employeeSex) &&
                Objects.equals(employeePhone, that.employeePhone) &&
                Objects.equals(employeeMail, that.employeeMail) &&
                Objects.equals(employeeAddress, that.employeeAddress) &&
                Objects.equals(employeeDateWork, that.employeeDateWork) &&
                Objects.equals(employeeImages, that.employeeImages) &&
                Objects.equals(employeeStatus, that.employeeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeFullName, employeeDateBirth, employeeSex, employeePhone, employeeMail, employeeAddress, employeeDateWork, employeeImages, employeeStatus);
    }
}
