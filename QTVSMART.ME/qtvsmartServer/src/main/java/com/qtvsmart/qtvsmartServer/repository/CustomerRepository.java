package com.qtvsmart.qtvsmartServer.repository;

import com.qtvsmart.qtvsmartServer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(int id);
}
