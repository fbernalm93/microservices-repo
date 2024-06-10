package com.example.bankaccountservice.infrastructure.adapter.out;

import com.example.bankaccountservice.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAccountRepository extends JpaRepository<Account, Long> {
}
