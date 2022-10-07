package com.example.demo.employeeController;


import com.example.demo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.ServiceEmployee;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    public final ServiceEmployee serviceEmployee;

    @GetMapping(path = "/all")
    public Object allEmployee(){
        List<Employee> employees = null;
        try{
            employees = serviceEmployee.printAllEmployees();
        }catch (Throwable e){
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/all/departments")
    public Object printAllEmployeesByDepartment(@RequestParam(value = "department") int department) {
        List<Employee> employees = null;
        try {
            employees = serviceEmployee.printAllEmployeesForDepartment(department);
        }catch (Throwable e){
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/departments")
    public Object printAllEmployeesByDepartment() {
        List<Employee> employees = null;
        try {
            employees = serviceEmployee.printAllEmployeesByDepartment();
        }catch (Throwable e){
            return e.getMessage();
        }
        return employees;
    }

    @GetMapping(path = "/department/minSalary")
    public Object minSalaryEmployee (@RequestParam(value = "department") int department){
        Employee employee = null;
        try {
            employee = serviceEmployee.getMinSalary(department);
        }catch (Throwable e){
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/maxSalary")
    public Object maxSalaryEmployee(@RequestParam(value = "department") int department){
        Employee employee = null;
        try {
            employee = serviceEmployee.getMaxSalary(department);
        }catch (Throwable e){
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/add")
    public Object addEmployee (@RequestParam(value = "lastName") String lastName,
                                 @RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "middleName") String middleName,
                                 @RequestParam(value = "department") int department,
                                 @RequestParam(value = "salary") double salary) {
        Employee employee = null;
        try{
            employee = serviceEmployee.addEmployee(lastName, firstName, middleName, department, salary);
        }catch (Throwable e){
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/remove")
    public Object removeEmployee(@RequestParam(value = "lastName") String lastName,
                                   @RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "middleName") String middleName){
        Employee employee = null;
        try{
            serviceEmployee.removeEmployee(lastName, firstName, middleName);
        }catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }

    @GetMapping(path = "/find")
    public Object findEmployee(@RequestParam(value = "lastName") String lastName,
                                   @RequestParam(value = "firstName") String firstName,
                                   @RequestParam(value = "middleName") String middleName){
        Employee employee = null;
        try{
            serviceEmployee.removeEmployee(lastName, firstName, middleName);
        }catch (Throwable e) {
            return e.getMessage();
        }
        return employee;
    }
}

