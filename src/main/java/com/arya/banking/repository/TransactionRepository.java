package com.arya.banking.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arya.banking.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
