package com.employees.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
    private EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService) {
        this.employeesService = employeesService;
    }

    @GetMapping (path = "/add")
    public Employee addEmployee (@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName) {
        return employeesService.addEmployee(firstName, lastName);

    }
    @GetMapping (path = "/find")
    public Employee getEmployee (@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return employeesService.getEmployee(firstName, lastName);
    }

    @GetMapping (path = "/remove")
    public Employee removeEmployee(@RequestParam String firstName, String lastName) {
       return employeesService.removeEmployee(firstName, lastName);
    }

    @GetMapping
    public List<Employee> allEmployees(){
        return employeesService.allEmployyes();
    }


}
