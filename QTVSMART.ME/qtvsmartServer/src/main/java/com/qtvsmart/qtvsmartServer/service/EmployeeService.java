package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Employee;

import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee,String password);
    Employee getOneEmployee(Employee employee);
    Employee getById(int id);

    List<Employee> getAll();
}
