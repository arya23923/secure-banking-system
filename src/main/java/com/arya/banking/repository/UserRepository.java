package com.arya.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arya.banking.entity.User;
import java.util.UUID;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
