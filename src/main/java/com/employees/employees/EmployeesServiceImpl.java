package com.employees.employees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    final private int maxEmployees = 20;
    private Map<Employee, String> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
        else if (employees.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
        }
        employees.put(employee, employee.getFullName());
        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    @Override
    public List<Employee> allEmployyes() {
        return new ArrayList<>(employees.size());
    }
}



