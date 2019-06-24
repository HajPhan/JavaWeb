package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.EmployeesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private static List<EmployeesEntity> employees = new ArrayList<EmployeesEntity>();

    static {
        employees.add(new EmployeesEntity("Bill", "Gates"));
        employees.add(new EmployeesEntity("Steve", "Jobs"));
    }

    //Duoc tiem vao (inject) tu application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @Value("${success.message}")
    private String successMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = "/employee-list", method = RequestMethod.GET)
    public String employeeList(Model model) {
        model.addAttribute("employeesList", employees);
        return "employee-list";
    }

    @RequestMapping(value = "/employee-save", method = RequestMethod.GET)
    public String saveEmployee(Model model) {
        model.addAttribute("employee", new EmployeesEntity());
        return "employee-save";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String doSaveEmployee(Model model, @ModelAttribute("EmployeesEntity") EmployeesEntity employee) {
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
            EmployeesEntity newEmployee = new EmployeesEntity(firstName, lastName);
            employees.add(newEmployee);
            model.addAttribute("successMessage",successMessage);
            return "redirect:/employee-list";
        }
        model.addAttribute("errorMessage",errorMessage);
        return "employee-save";
    }
}
