package com.employees.employees;

import java.util.Collection;
import java.util.List;

public interface EmployeesService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);
    Employee getEmployee (String firstName, String lastName, int salary, int department);
    Employee removeEmployee(String firstName, String lastName, int salary, int department);

    Collection<Employee> allEmployyes();
}
