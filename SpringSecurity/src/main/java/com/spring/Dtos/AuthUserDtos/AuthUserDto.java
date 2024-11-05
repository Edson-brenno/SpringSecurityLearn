package com.spring.Dtos.AuthUserDtos;

import com.spring.Entity.AuthUser;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * This dto is responsible to return the needed information of the user
 * @param id id of the user
 * @param username username of the user
 * @param firstName first name of user
 * @param lastName last name of the user
 * @param email email of the user*/
public record AuthUserDto (

        Long id,

        @NotNull(message = "The username cannot be null")
        @Column(nullable = false)
        @Size(min = 5, max = 100, message = "The username needs to have 5 to 100 characters")
        String username,

        @NotNull(message = "The first name cannot be null")
        @Column(nullable = false)
        @Size(min = 1, max = 250, message = "The first name needs to have 1 to 250 characters")
        String firstName,

        @NotNull(message = "The last name cannot be null")
        @Column(nullable = false)
        @Size(min = 1, max = 250, message = "The last name needs to have 1 to 250 characters")
        String lastName,

        @Email(message = "Please, inform a valid email")
        String email

) {
    // constructor method of the dto
    public AuthUserDto (AuthUser authUser){
        this(authUser.getId(), authUser.getUsername(), authUser.getFirstName(),
                authUser.getLastName(), authUser.getEmail());
    }
}
