package com.arya.banking.repository;

import java.util.Optional;
import java.util.UUID;
import com.arya.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findByIdAndUserId(UUID id, UUID userId);
}
