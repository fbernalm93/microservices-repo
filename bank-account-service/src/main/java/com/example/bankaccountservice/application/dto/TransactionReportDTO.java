package com.example.bankaccountservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TransactionReportDTO {
    private LocalDateTime date;
    private String transactionType;
    private double amount;
    private double balance;
}
