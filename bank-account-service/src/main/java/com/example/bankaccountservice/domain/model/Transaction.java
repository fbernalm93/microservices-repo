package com.example.bankaccountservice.domain.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @NotEmpty(message="Field is required")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotEmpty(message="Field is required")
    @Column(name="date")
    private LocalDateTime date;
    @NotEmpty(message="Field is required")
    @Column(name="transactionType")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @NotEmpty(message="Field is required")
    @Column(name="amount")
    private double amount;
    @NotEmpty(message="Field is required")
    @Column(name="balance")
    private double balance;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
