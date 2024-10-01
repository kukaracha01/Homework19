package com.employees.employees;

import java.util.List;

public interface EmployeesService {
    Employee addEmployee(String firstName, String lastName);
    Employee getEmployee (String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);

    List<Employee> allEmployyes();
}
