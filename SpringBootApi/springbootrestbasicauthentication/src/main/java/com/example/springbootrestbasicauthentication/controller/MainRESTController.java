package com.example.springbootrestbasicauthentication.controller;

import com.example.springbootrestbasicauthentication.dao.EmployeeDAO;
import com.example.springbootrestbasicauthentication.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
public class MainRESTController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/")
    public String welcome(){
        return "Welcome to RestTemple Example";
    }

    @RequestMapping(value = "/employees",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Employee> getEmplyee(){
        List<Employee> list = employeeDAO.getAllEmployees();
        return list;
    }


}
