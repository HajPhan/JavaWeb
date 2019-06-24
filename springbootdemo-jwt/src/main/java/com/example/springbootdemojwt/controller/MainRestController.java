package com.example.springbootdemojwt.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.springbootdemojwt.dao.EmployeeDAO;
import com.example.springbootdemojwt.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRestController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/")
    @ResponseBody
    public String welcome(){
        return "Welcome to Spring Boot + Rest + JWT Example.";
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "{greeting: 'Hello'}";
    }

    //URL:
    //http://localhost:8080/employees
    @RequestMapping(value = "/employees",method = RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }

    //URL
    //http://localhost:8080/employee{id}
    @RequestMapping(value = "/employees/{empNo}",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Employee getEmployee(@PathVariable String empNo){
        return employeeDAO.getEmployee(empNo);
    }

    //URL
    //http://localhost:8080/employee
    @RequestMapping(value = "/employees",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Employee addEmployee(@RequestBody Employee emp){
        System.out.println("(Service Side) Creating Employee: " + emp.getEmpNo());
        return employeeDAO.addEmployee(emp);
    }

    //URL
    //http:localhost:8080/employee
    @RequestMapping(value = "/employees",method = RequestMethod.PUT,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Employee updateEmployee(@RequestBody Employee emp){
        System.out.println("(Service Side) Editing Employee" + emp.getEmpNo());
        return employeeDAO.updateEmployee(emp);
    }

    //URL
    //http:localhost:8080/employee/{id}
    @RequestMapping(value = "/employee/{empNo}",method = RequestMethod.DELETE,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public void deleteEmployee(@PathVariable String empNo){
        System.out.println("(Service Side) Deleting Employee: " + empNo);
        employeeDAO.deleteEmployee(empNo);
    }

}
