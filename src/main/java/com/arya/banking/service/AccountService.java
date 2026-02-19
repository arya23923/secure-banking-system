package com.arya.banking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.arya.banking.entity.Account;
import com.arya.banking.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepo;

    public Account getAccount(UUID accountId) {
        return accountRepo.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public BigDecimal getBalance(UUID accountId) {
        return getAccount(accountId).getBalance();
    }

    public Account createAccount(Account account) {
        account.setBalance(BigDecimal.ZERO);
        return accountRepo.save(account);
    }

    public void updateBalance(Account account, BigDecimal newBalance) {
        account.setBalance(newBalance);
        accountRepo.save(account);
    }
}
