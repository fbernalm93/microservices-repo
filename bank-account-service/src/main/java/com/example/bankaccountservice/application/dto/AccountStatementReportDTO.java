package com.example.bankaccountservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AccountStatementReportDTO {
    private String customerId;
    private List<AccountReportDTO> accounts;
}