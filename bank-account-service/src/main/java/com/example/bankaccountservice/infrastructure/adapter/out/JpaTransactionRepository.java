package com.example.bankaccountservice.infrastructure.adapter.out;

import com.example.bankaccountservice.domain.model.Transaction;
import com.example.bankaccountservice.domain.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaTransactionRepository implements TransactionRepository {

    @Autowired
    private SpringDataTransactionRepository springDataTransactionRepository;

    @Override
    public List<Transaction> findAll() {
        return springDataTransactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return springDataTransactionRepository.findById(id);
    }

    @Override
    public Transaction save(Transaction transaction) {
        return springDataTransactionRepository.save(transaction);
    }

    @Override
    public void deleteById(Long id) {
        springDataTransactionRepository.deleteById(id);
    }
}