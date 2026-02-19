package com.arya.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arya.banking.entity.IdempotencyKey;

public interface IdempotencyRepository extends JpaRepository<IdempotencyKey, String> {

}
