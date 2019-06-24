package com.example.springbootdemojwt.model;

public class Employee {

    private String empNo;
    private String empName;
    private String postion;

    public Employee() {

    }

    public Employee(String empNo, String empName, String postion) {
        this.empNo = empNo;
        this.empName = empName;
        this.postion = postion;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }
}
