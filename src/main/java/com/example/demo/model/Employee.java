package com.example.demo.model;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String middleName;
    private int department;
    private double salary;
    private int id;
    private static int counter;

    public Employee(String lastName, String firstName, String middleName, int department, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public String toString(){
        return "\nФИО сотрудника: "
                + this.lastName + " "
                + this.firstName + " "
                + this.middleName +". " + "Отдел - "
                + this.department + ". " + "Зарплата: "
                + this.salary + ".";
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getMiddleName(){
        return this.middleName;
    }


    public int getDepartment(){
        return this.department;
    }

    public double getSalary(){
        return this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {

        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName, department, salary);
    }


}
