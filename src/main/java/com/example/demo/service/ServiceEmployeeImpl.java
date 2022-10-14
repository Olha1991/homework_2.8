package com.example.demo.service;

import com.example.demo.exceptions.EmployeeAlreadyAddedException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.exceptions.InvalidInputException;
import com.example.demo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class ServiceEmployeeImpl implements ServiceEmployee {

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivanov", "Ivan", "Ivanovich", 1, 1000),
            new Employee("Petrovova", "Mariya", "Petrovna", 2, 2000),
            new Employee("Romanuk", "Yan", "Igorevich", 4, 3000),
            new Employee("Tarasov", "Egor", "Tarasovich", 4, 4000),
            new Employee("Shevchenko", "Olga", "Ivanovna", 5, 5000),
            new Employee("Pechkin", "Roman", "Aleksandrovich", 1, 6000),
            new Employee("Belkina", "Vera", "Petrovna", 2, 7000),
            new Employee("Matvienko", "Larisa", "Zaharovna", 3, 8000),
            new Employee("Prokopenko", "Yana", "Sidorovna", 4, 9000),
            new Employee("Bashmakov", "Igor", "Fedorovich", 5, 10000)
    ));

    @Override
    public List<Employee> printAllEmployees() {
        return employees;
    }
    @Override
    public List<Employee> printAllEmployeesForDepartment(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    @Override
    public List <Employee> printAllEmployeesByDepartment(){
        return Collections.unmodifiableList(employees.stream()
                .sorted(Comparator.comparingInt(e -> e.getDepartment()))
                .collect(Collectors.toList()));
    }
    @Override
    public Employee getMinSalary(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(e -> (int) e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

    }

    @Override
    public Employee getMaxSalary(int department) {
        return employees.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(e -> (int) e.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }



    @Override
    public Employee addEmployee(String lastName, String firstName, String middleName, int department, double salary) {
        validateInput(lastName, firstName, middleName);
        Employee employee = new Employee(lastName, firstName, middleName, department, salary);
        if(employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже усть.");
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public Employee removeEmployee(String lastName, String firstName, String middleName) {
        validateInput(lastName, firstName, middleName);
        Employee employee = findEmployee(lastName, firstName,middleName);
        employees.remove(employee);
        return employee;
    }


    @Override
    public Employee findEmployee(String lastName, String firstName, String middleName) {
        validateInput(lastName, firstName, middleName);
        final Optional<Employee> employee = employees.stream()
                .filter(e -> e.getLastName().equals(lastName)
                        && e.getFirstName().equals(firstName)
                        && e.getMiddleName().equals(middleName))
                .findAny();
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден."));
    }

    private void validateInput(String lastName, String firstName, String middleName){
        if(!(isAlpha(firstName) && isAlpha(lastName) && isAlpha(middleName))){
            throw new InvalidInputException();
        }
    }

}



