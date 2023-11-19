package com.mikhail.spring.springboot.springboot_rest.dao;

import com.mikhail.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public void delEmployee(int empId);

    public Employee getEmployee(int empId);
}