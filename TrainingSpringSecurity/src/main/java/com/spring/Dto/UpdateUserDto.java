package com.spring.Dto;

import jakarta.validation.constraints.NotNull;

/**
 * This dto it'll be used to update the information of one registered user
 * @param id of the user to updated
 * @param nome name of the user to be updated
 * @param email email of the user to be updated*/
public record UpdateUserDto (
        @NotNull(message = "The id of the user to be updated cannot be null")
        Long id,

        @NotNull(message = "The new name of the user cannot be null")
        String nome,

        String email
){
}
