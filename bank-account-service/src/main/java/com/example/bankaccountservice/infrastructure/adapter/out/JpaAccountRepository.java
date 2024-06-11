package com.example.bankaccountservice.infrastructure.adapter.out;

import com.example.bankaccountservice.domain.model.Account;
import com.example.bankaccountservice.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaAccountRepository implements AccountRepository {

    @Autowired
    private SpringDataAccountRepository springDataAccountRepository;

    @Override
    public List<Account> findAll() {
        return springDataAccountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return springDataAccountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return springDataAccountRepository.save(account);
    }

    @Override
    public void deleteById(Long id) {
        springDataAccountRepository.deleteById(id);
    }

    @Override
    public List<Account> findByCustomerId(String customerId) {
        return springDataAccountRepository.findAll().stream().filter(account -> account.getCustomerId().equals(customerId)).toList();
    }
}