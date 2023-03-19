package com.qtvsmart.qtvsmartServer.service;

import com.qtvsmart.qtvsmartServer.entity.Account;
import com.qtvsmart.qtvsmartServer.entity.Customer;

import java.util.List;

public interface CustomerService {
    int addCustomer(Customer customer, String password);

    Customer getCustomerById(int id);

    List<Customer> getAll();

    Customer getOne(Customer customer);

}
