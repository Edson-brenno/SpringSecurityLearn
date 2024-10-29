package com.spring.Repository;


import com.spring.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository to work with the user
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
