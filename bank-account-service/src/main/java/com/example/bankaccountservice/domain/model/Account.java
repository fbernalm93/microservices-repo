package com.example.bankaccountservice.domain.model;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;


import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotEmpty(message="Field is required")
    @Column(name="accountNumber")
    @Pattern(regexp ="^[0-9]*$", message = "The field Name should always contain digits")
    private String accountNumber;
    @Column(name="accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name="initialBalance")
    private double initialBalance;
    @Column(name="state")
    @ColumnDefault("true")
    private boolean state;
    @NotEmpty(message="Field is required")
    @Column(name="customerId")
    private String customerId;  // Reference to Customer

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }

}
