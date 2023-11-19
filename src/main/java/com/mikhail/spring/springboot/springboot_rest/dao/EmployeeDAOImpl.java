package com.mikhail.spring.springboot.springboot_rest.dao;

import com.mikhail.spring.springboot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {

        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        // при совпадении primary key будет происходить update
        session.saveOrUpdate(employee);
    }

    @Override
    public void delEmployee(int empId) {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        // bind значения на метку
        query.setParameter("employeeId", empId);
        query.executeUpdate();

        //Employee employee = session.get(Employee.class, empId);
        //session.delete(employee);
    }

    @Override
    public Employee getEmployee(int empId) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, empId);
        return  employee;
    }

}