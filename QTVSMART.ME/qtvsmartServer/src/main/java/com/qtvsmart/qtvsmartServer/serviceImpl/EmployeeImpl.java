package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Customer;
import com.qtvsmart.qtvsmartServer.entity.Employee;
import com.qtvsmart.qtvsmartServer.repository.AccountRepository;
import com.qtvsmart.qtvsmartServer.repository.EmployeeRepository;
import com.qtvsmart.qtvsmartServer.service.AccountService;
import com.qtvsmart.qtvsmartServer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @Override
    public String createEmployee(Employee employee, String password) {
        Account account = new Account();
        account.setEmail(employee.getEmail());
        account.setPassword(password);
        account.setEnable(true);

        accountRepository.save(account);

        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setPosition(employee.getPosition());
        employee1.setPhone(employee.getPhone());
        employee1.setSex(employee.getSex());
        employee1.setNgaySinh(employee.getNgaySinh());
        employee1.setAccount(account);

        employeeRepository.save(employee1);
        return "success";
    }

    @Override
    public Employee getOneEmployee(Employee employee) {

        Employee employee1 = new Employee();
        Account account = accountService.getOne(employee.getAccount());
        employee1.setId(employee.getId());
        employee1.setEmail(employee.getEmail());
        employee1.setName(employee.getName());
        employee1.setSex(employee.getSex());
        employee1.setPosition(employee.getPosition());
        employee1.setNgaySinh(employee.getNgaySinh());
        employee1.setAccount(account);

        return employee1;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        Employee employee1 = getOneEmployee(employee);
        return employee1;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        for (Employee employee1 : employeeList) {
            employee = getOneEmployee(employee1);
            employees.add(employee);
        }
        return employees;
    }
}
