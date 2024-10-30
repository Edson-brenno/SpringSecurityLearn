package com.spring.Dto.UserAuthDtos;

/**
 * Dto responsible to register a new user to login on the system
 * @param userName name of the user
 * @param passWord password of to login*/
public record RegisterUserAuthDto (
        String userName,
        String passWord
){
}
