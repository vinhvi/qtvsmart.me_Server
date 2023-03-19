package com.qtvsmart.qtvsmartServer.controller;

import com.qtvsmart.qtvsmartServer.entity.Employee;
import com.qtvsmart.qtvsmartServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create/{password}")
    public String createEmployee(@RequestBody Employee employee, @PathVariable("password") String password) {
        return employeeService.createEmployee(employee, password);
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id) {
        return employeeService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}
