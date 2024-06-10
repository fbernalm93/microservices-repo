package com.example.bankaccountservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountReportDTO {
    private Long accountId;
    private String accountNumber;
    private double balance;
    private List<TransactionReportDTO> transactions;
}
