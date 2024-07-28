package com.employees.employees;

import java.util.Objects;

import static java.util.Objects.hash;

public class Employee {
    private String firstName;
    private String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        return hash(firstName, lastName);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        Employee e = (Employee) other;
        return Objects.equals(firstName, e.firstName) && Objects.equals(lastName, e.lastName);
    }


    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
