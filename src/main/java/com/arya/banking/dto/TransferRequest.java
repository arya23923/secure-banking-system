package com.arya.banking.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter
public class TransferRequest {
    private UUID from;
    private UUID to;
    private BigDecimal amount;
}
