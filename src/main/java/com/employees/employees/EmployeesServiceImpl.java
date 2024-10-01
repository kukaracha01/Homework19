package com.employees.employees;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    final private int maxEmployees = 1;
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Викторов"),
            new Employee("Иван", "Тимуров"),
            new Employee("Александр", "Иванов"),
            new Employee("Алексей", "Росин"),
            new Employee("Константин", "Головин"),
            new Employee("Дмитрий", "Довлатов")));

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
        else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    @Override
    public List<Employee> allEmployyes() {
        return new ArrayList<>(employees);
    }
}



