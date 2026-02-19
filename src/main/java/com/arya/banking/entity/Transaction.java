package com.arya.banking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter @Setter
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;
    
    private UUID fromAccountId;
    private UUID toAccountId;

    private BigDecimal amoiunt;

    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();
}
