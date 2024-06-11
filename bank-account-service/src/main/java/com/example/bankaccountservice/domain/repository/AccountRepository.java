package com.example.bankaccountservice.domain.repository;

import com.example.bankaccountservice.application.dto.CustomerDTO;
import com.example.bankaccountservice.domain.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();
    Optional<Account> findById(Long id);
    Account save(Account account);
    void deleteById(Long id);
    List<Account> findByCustomerId(String customerId);
}