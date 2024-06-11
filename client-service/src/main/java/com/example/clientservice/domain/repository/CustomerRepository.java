package com.example.clientservice.domain.repository;
import com.example.clientservice.domain.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> findAll();
    Optional<Customer> findById(String id);
    Customer save(Customer customer);
    void deleteById(String id);
}
