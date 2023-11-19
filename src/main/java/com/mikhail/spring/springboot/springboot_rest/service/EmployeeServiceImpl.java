package com.mikhail.spring.springboot.springboot_rest.service;

import com.mikhail.spring.springboot.springboot_rest.dao.EmployeeDAO;
import com.mikhail.spring.springboot.springboot_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void delEmployee(int empId) {
        employeeDAO.delEmployee(empId);
    }

    @Override
    @Transactional
    public Employee getEmployee(int empId) {
        return employeeDAO.getEmployee(empId);
    }

}