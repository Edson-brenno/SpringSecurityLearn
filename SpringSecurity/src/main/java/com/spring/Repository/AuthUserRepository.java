package com.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.Entity.AuthUser;

// AuthUserRepository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
}
