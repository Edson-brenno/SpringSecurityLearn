package com.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.Entity.AuthUser;

import java.util.Optional;

// AuthUserRepository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsername(String username);
}
