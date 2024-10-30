package com.spring.Dto.UserAuthDtos;

/**
 * Dto responsible to update a user
 * @param id id of the user
 * @param userName name of the user
 * @param passWord password of to login*/
public record UpdateUserAuthDto (
        Long id,
        String userName,
        String passWord
){
}
