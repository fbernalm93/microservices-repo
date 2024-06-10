package com.example.clientservice.infrastructure.adapter.out;

import com.example.clientservice.domain.model.Customer;
import com.example.clientservice.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

    @Autowired
    private SpringDataCustomerRepository springDataCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return springDataCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return springDataCustomerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return springDataCustomerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        springDataCustomerRepository.deleteById(id);
    }
}
