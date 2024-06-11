package com.example.clientservice.infrastructure.adapter.out;

import com.example.clientservice.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCustomerRepository extends JpaRepository<Customer, String> {
}
