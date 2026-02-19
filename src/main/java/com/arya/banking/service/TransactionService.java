package com.arya.banking.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.arya.banking.entity.Account;
import com.arya.banking.repository.AccountRepository;
import com.arya.banking.repository.TransactionRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.UUID;

import com.arya.banking.entity.Transaction;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final AccountService accountService;
    private final TransactionRepository transactionRepo;

    @Transactional
    public String transfer(UUID fromId, UUID toId, BigDecimal amount) {

        Account from = accountService.getAccount(fromId);
        Account to = accountService.getAccount(toId);

        if (from.getBalance().compareTo(amount) < 0)
            throw new RuntimeException("Insufficient balance");

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        accountService.updateBalance(from, from.getBalance());
        accountService.updateBalance(to, to.getBalance());

        Transaction tx = new Transaction();
        tx.setFromAccountId(fromId);
        tx.setToAccountId(toId);
        tx.setAmount(amount);
        tx.setStatus("SUCCESS");

        transactionRepo.save(tx);

        return "Transfer successful";
    }
}
