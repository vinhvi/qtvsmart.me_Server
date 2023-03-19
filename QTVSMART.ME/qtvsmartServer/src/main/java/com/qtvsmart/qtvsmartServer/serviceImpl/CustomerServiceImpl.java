package com.qtvsmart.qtvsmartServer.serviceImpl;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Customer;
import com.qtvsmart.qtvsmartServer.entity.Role;
import com.qtvsmart.qtvsmartServer.repository.AccountRepository;
import com.qtvsmart.qtvsmartServer.repository.CustomerRepository;
import com.qtvsmart.qtvsmartServer.service.AccountService;
import com.qtvsmart.qtvsmartServer.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;


    @Override
    public int addCustomer(Customer customer, String password) {
        Account account = new Account();
        account.setEmail(customer.getEmail());
        account.setPassword(password);
        account.setEnable(true);

        accountRepository.save(account);

        Customer customer1 = new Customer();
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
        customer1.setPhone(customer.getPhone());
        customer1.setSex(customer.getSex());
        customer1.setNgaySinh(customer.getNgaySinh());
        customer1.setAccount(account);

        customerRepository.save(customer1);

        return account.getId();
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = customerRepository.findCustomerById(id);
        Customer customer1 = getOne(customer);
        return customer1;

    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<Customer> customers1 = new ArrayList<>();
        Customer customer1 = new Customer();
        for (Customer customer : customers) {
            customer1 = getOne(customer);
            customers1.add(customer1);
        }
        return customers1;
    }

    @Override
    public Customer getOne(Customer customer) {
        Customer customerSet = new Customer();
        Account account = accountService.getOne(customer.getAccount());
        customerSet.setId(customer.getId());
        customerSet.setEmail(customer.getEmail());
        customerSet.setName(customer.getName());
        customerSet.setSex(customer.getSex());
        customerSet.setAddress(customer.getAddress());
        customerSet.setNgaySinh(customer.getNgaySinh());
        customerSet.setAccount(account);
        return customerSet;
    }


}
