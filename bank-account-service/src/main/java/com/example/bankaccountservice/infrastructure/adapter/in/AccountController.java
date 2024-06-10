package com.example.bankaccountservice.infrastructure.adapter.in;

import com.example.bankaccountservice.application.dto.AccountStatementReportDTO;
import com.example.bankaccountservice.application.service.AccountService;
import com.example.bankaccountservice.domain.exception.InsufficientBalanceException;
import com.example.bankaccountservice.domain.model.Account;
import com.example.bankaccountservice.domain.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/transactions")
    public ResponseEntity<?> addTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
        try {
            Transaction createdTransaction = accountService.addTransaction(id, transaction);
            return ResponseEntity.ok(createdTransaction);
        } catch (InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/reportes")
    public ResponseEntity<AccountStatementReportDTO> getAccountStatement(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam("customer") String customerId) {
        AccountStatementReportDTO report = accountService.generateAccountStatement(customerId, fechaInicio, fechaFin);
        return ResponseEntity.ok(report);
    }
}