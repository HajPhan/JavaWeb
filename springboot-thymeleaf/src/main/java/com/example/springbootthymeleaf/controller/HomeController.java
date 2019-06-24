package com.example.springbootthymeleaf.controller;

import com.example.springbootthymeleaf.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    Environment environment;

    public static List<Employee> list = Arrays.asList(new Employee(1, "A"),
            new Employee(2, "B"),
            new Employee(3, "C"),
            new Employee(4, "D"),
            new Employee(5, "E"),
            new Employee(6, "F"),
            new Employee(7, "G"));


    public static void main(String[] args) {
        for (Employee e : list) {
            System.out.println(e.getId() + " - " + e.getName());
        }
    }


    @RequestMapping(value = "/")
    public String index(HttpServletRequest request, Model model) {
        request.setAttribute("msg", environment.getProperty("message"));
        model.addAttribute("number", 10);
        model.addAttribute("hello", environment.getProperty("hello"));
        model.addAttribute("employee", list);
        return "index";
    }
}
