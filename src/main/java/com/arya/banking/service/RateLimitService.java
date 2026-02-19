package com.arya.banking.service;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class RateLimitService {
    private static final int MAX_REQUESTS = 5;
    private static final long WINDOW_SECONDS = 60;

    private final Map<UUID, Integer> requestCount = new ConcurrentHashMap<>();
    private final Map<UUID, Instant> windowStart = new ConcurrentHashMap<>();

    public void checkLimit(UUID accountId) {

        Instant now = Instant.now();

        windowStart.putIfAbsent(accountId, now);
        requestCount.putIfAbsent(accountId, 0);

        Instant start = windowStart.get(accountId);

        // Reset window if expired
        if (now.isAfter(start.plusSeconds(WINDOW_SECONDS))) {
            windowStart.put(accountId, now);
            requestCount.put(accountId, 0);
        }

        int currentCount = requestCount.get(accountId);

        if (currentCount >= MAX_REQUESTS) {
            throw new RuntimeException("Too many transfer attempts. Try again later.");
        }

        requestCount.put(accountId, currentCount + 1);
    }
}
