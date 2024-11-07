package com.employees.employees;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableCollection;
import static org.apache.commons.lang3.StringUtils.isAllLowerCase;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    final private int maxEmployees = 20;
    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        if (!validateImpl(firstName, lastName)) {
            throw new ValidateImplException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= maxEmployees) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        } else if (employees.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("такой сотрудник уже есть");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee getEmployee(String firstName, String lastName, int salary, int department) {
        if (!validateImpl(firstName, lastName)) {
            throw new ValidateImplException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        if (!validateImpl(firstName, lastName)) {
            throw new ValidateImplException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");
    }

    @Override
    public Collection<Employee> allEmployyes() {
        return unmodifiableCollection(employees.values());
    }

    private boolean validateImpl(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}



