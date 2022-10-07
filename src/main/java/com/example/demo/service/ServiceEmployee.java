package com.example.demo.service;


import com.example.demo.model.Employee;

import java.util.List;

public interface ServiceEmployee {

    List<Employee> printAllEmployees();
    List<Employee> printAllEmployeesForDepartment(int department);

    List <Employee> printAllEmployeesByDepartment();

    Employee getMinSalary(int department);

    Employee getMaxSalary(int department);

    Employee addEmployee(String lastName, String firstName, String middleName, int department, double salary);

    Employee removeEmployee(String lastName, String firstName, String middleName);

    Employee findEmployee(String lastName, String firstName, String middleName);
}
