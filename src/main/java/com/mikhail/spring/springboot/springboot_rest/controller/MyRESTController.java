package com.mikhail.spring.springboot.springboot_rest.controller;

import com.mikhail.spring.springboot.springboot_rest.entity.Employee;
import com.mikhail.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        Employee emp = employeeService.getEmployee(id);

        return emp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        Employee emp = employeeService.getEmployee(employee.getId());

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String delEmployee(@PathVariable int id) {

        Employee emp = employeeService.getEmployee(id);

        employeeService.delEmployee(id);
        return "Employee ID = " + id + " was deleted.";
    }


}
