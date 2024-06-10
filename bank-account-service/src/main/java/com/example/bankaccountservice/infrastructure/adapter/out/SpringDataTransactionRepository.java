package com.example.bankaccountservice.infrastructure.adapter.out;

import com.example.bankaccountservice.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTransactionRepository extends JpaRepository<Transaction, Long> {
}