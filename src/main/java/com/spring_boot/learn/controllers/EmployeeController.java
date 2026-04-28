package com.spring_boot.learn.controllers;

import com.spring_boot.learn.entities.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    ArrayList<Employee> employees = new ArrayList<Employee>();

    @GetMapping
    public ArrayList<Employee> findAll() {
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> helloWorld(@PathVariable UUID employeeId) {
        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId().equals(employeeId)).findFirst();
        return employee;
    }

    @PostMapping
    public Employee CreateOne(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employee.setDepartementID(UUID.randomUUID());
        employees.add(employee);
        return employee;
    }

    @PutMapping("/{EmployeeId}")
    public Employee updateOne(@PathVariable UUID EmployeeId, @RequestBody Employee employee) {
        Optional<Employee> employeeToUpdate = employees.stream().filter(emp -> emp.getId().equals(EmployeeId))
                .findFirst();
        if (employeeToUpdate.isPresent()) {
            employeeToUpdate.get().setFirst_name(employee.getFirst_name());
            employeeToUpdate.get().setLast_name(employee.getLast_name());
            employeeToUpdate.get().setEmail(employee.getEmail());
            employeeToUpdate.get().setPhone_number(employee.getPhone_number());
            employeeToUpdate.get().setHire_date(employee.getHire_date());
            employeeToUpdate.get().setPosition(employee.getPosition());
            return employeeToUpdate.get();
        } else {
            System.err.println("cannot find the Emp pls retry later");
            return null;
        }
    }

    @DeleteMapping("/{EmployeeId}")
    public void deleteOne(@PathVariable UUID EmployeeId) {
        Optional<Employee> employee = employees.stream().filter(emp -> emp.getId().equals(EmployeeId)).findFirst();
        if (employee.isPresent()) {
            employees.remove(employee.get());
        } else {
            System.err.println("cannot find the Emp pls retry later");
        }
    }
}
