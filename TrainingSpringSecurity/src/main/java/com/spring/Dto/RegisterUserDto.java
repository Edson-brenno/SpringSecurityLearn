package com.spring.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * This dto is responsible to have the needed information to register a new user*/
public record RegisterUserDto(

        @NotNull(message = "O nome do usuario não pode ser nulo")
        @Size(min = 1, max = 250, message = "O nome do usuário deve ter entre 1 á 250 caracteres")
        String nome,

        String email
){
}
