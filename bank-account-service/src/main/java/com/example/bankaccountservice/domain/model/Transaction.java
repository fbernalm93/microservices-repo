package com.example.bankaccountservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="date")
    private LocalDateTime date;
    @Column(name="transactionType")
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @Column(name="amount")
    private double amount;
    @Column(name="balance")
    private double balance;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "account_id")
    private Account account;
}
