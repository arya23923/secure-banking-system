package com.arya.banking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arya.banking.dto.TransferRequest;
import com.arya.banking.entity.IdempotencyKey;
import com.arya.banking.repository.IdempotencyRepository;
import com.arya.banking.service.TransactionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final IdempotencyRepository idempotencyRepo;

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(
            @RequestHeader("Idempotency-Key") String key,
            @RequestBody TransferRequest request) {

        if (idempotencyRepo.existsById(key)) {
            return ResponseEntity.ok(
                    idempotencyRepo.findById(key).get().getResponse()
            );
        }

        String response = transactionService.transfer(
                request.getFrom(),
                request.getTo(),
                request.getAmount()
        );

        IdempotencyKey idk = new IdempotencyKey();
        idk.setKey(key);
        idk.setResponse(response);
        idempotencyRepo.save(idk);

        return ResponseEntity.ok(response);
    }
}
