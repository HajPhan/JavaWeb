package com.example.springbootrestbasicauthentication.dao;

import com.example.springbootrestbasicauthentication.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDAO {
    private static final Map<String, Employee> empMap = new HashMap<String,Employee>();

    static {
        initEmps();
    }

    private static void initEmps(){
        Employee e1 = new Employee("1","Hai","Clerk");
        Employee e2 = new Employee("2","Van","Saleman");
        Employee e3 = new Employee("3","Phan","Manager");

        empMap.put(e1.getEmpNo(),e1);
        empMap.put(e2.getEmpNo(),e2);
        empMap.put(e3.getEmpNo(),e3);

    }


    public Employee getEmployee(String empNo){
        return empMap.get(empNo);
    }

    public Employee addEmployee(Employee emp){
        empMap.put(emp.getEmpNo(),emp);
        return emp;
    }

    public Employee updateEmployee(Employee emp){
        empMap.put(emp.getEmpNo(),emp);
        return emp;
    }

    public List<Employee> getAllEmployees(){
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
}
