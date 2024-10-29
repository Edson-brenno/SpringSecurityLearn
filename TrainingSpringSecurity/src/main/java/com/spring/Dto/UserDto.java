package com.spring.Dto;

import com.spring.Entity.UsuarioEntity;

/**
 * This dto it'll be used to return the essential information of the user
 * @param id of the user on the database
 * @param nome name of the user
 * @param email email of the user*/
public record UserDto (
        Long id,
        String nome,
        String email
) {
    public UserDto(UsuarioEntity user){
        this(user.getId(),user.getNome(),user.getEmail());
    }
}
