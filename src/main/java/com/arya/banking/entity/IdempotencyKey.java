package com.arya.banking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "idempotency_keys")
@Getter @Setter
public class IdempotencyKey {

    @Id
    private String key;

    @Lob
    private String response;

    private LocalDateTime createdAt = LocalDateTime.now();
}
