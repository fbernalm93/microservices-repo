package com.example.bankaccountservice.application.service;

import com.example.bankaccountservice.application.client.CustomerServiceClient;
import com.example.bankaccountservice.application.dto.AccountReportDTO;
import com.example.bankaccountservice.application.dto.AccountStatementReportDTO;
import com.example.bankaccountservice.application.dto.CustomerDTO;
import com.example.bankaccountservice.application.dto.TransactionReportDTO;
import com.example.bankaccountservice.domain.exception.InsufficientBalanceException;
import com.example.bankaccountservice.domain.model.Account;
import com.example.bankaccountservice.domain.model.Transaction;
import com.example.bankaccountservice.domain.model.TransactionType;
import com.example.bankaccountservice.domain.repository.AccountRepository;
import com.example.bankaccountservice.infrastructure.adapter.out.JpaTransactionRepository;
import io.swagger.v3.core.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private JpaTransactionRepository jpaTransactionRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;

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

        if(TransactionType.DEPOSITO == transaction.getTransactionType())
        {
            transaction.setBalance(account.getInitialBalance() + transaction.getAmount());
        } else {
            transaction.setBalance(account.getInitialBalance() - transaction.getAmount());
        }

        if (transaction.getBalance()  < 0) {
            throw new InsufficientBalanceException("Saldo no disponible");
        }

        transaction.setDate(LocalDateTime.now());

        account.addTransaction(transaction);

        accountRepository.save(account);
        return jpaTransactionRepository.save(transaction);
    }

    public AccountStatementReportDTO generateAccountStatement(String customerId, LocalDateTime startDate, LocalDateTime endDate) {
        CustomerDTO customer = customerServiceClient.getCustomerById(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        List<AccountReportDTO> accountReportDTOS = accounts.stream().map(account -> {
            List<TransactionReportDTO> transactionReportDTOS = account.getTransactions().stream()
                    .filter(transaction -> transaction.getDate().isAfter(startDate) && transaction.getDate().isBefore(endDate))
                    .map(transaction -> new TransactionReportDTO(
                            transaction.getDate(),
                            transaction.getTransactionType().name(),
                            transaction.getAmount(),
                            transaction.getBalance()))
                    .collect(Collectors.toList());

            return new AccountReportDTO(
                    account.getId(),
                    account.getAccountNumber(),
                    account.getInitialBalance(),
                    transactionReportDTOS);
        }).collect(Collectors.toList());

        return new AccountStatementReportDTO(customerId, accountReportDTOS);
    }
}