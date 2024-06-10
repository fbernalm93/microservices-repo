package com.example.bankaccountservice.domain.model;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


import java.util.List;

@Entity
@Data
public class Account {
    @NotEmpty(message="Field is required")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotEmpty(message="Field is required")
    @Column(name="accountNumber")
    @Pattern(regexp ="^[0-9]*$", message = "The field Name should always contain digits")
    private String accountNumber;
    @NotEmpty(message="Field is required")
    @Column(name="accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @NotEmpty(message="Field is required")
    @Column(name="initialBalance")
    private double initialBalance;
    @NotEmpty(message="Field is required")
    @Column(name="state")
    private boolean state;
    @NotEmpty(message="Field is required")
    @Column(name="customerId")
    private Long customerId;  // Reference to Customer

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
        updateBalance(transaction.getAmount());
    }

    private void updateBalance(double amount) {
        initialBalance += amount;
    }
}
