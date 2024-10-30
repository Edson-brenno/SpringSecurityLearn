package com.spring.Repository;

import com.spring.Entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

// User Auth repository
public interface UserAuthRepository extends JpaRepository<AuthUser, Long> {
}
