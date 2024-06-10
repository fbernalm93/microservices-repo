package com.example.bankaccountservice.application.service;

import com.example.bankaccountservice.domain.model.Account;
import com.example.bankaccountservice.domain.model.Transaction;
import com.example.bankaccountservice.domain.repository.AccountRepository;
import com.example.bankaccountservice.infrastructure.adapter.out.JpaTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private JpaTransactionRepository jpaTransactionRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Transaction addTransaction(Long accountId, Transaction transaction) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        transaction.setDate(LocalDateTime.now());
        transaction.setBalance(account.getInitialBalance() + transaction.getAmount());
        account.addTransaction(transaction);

        accountRepository.save(account);
        return jpaTransactionRepository.save(transaction);
    }
}