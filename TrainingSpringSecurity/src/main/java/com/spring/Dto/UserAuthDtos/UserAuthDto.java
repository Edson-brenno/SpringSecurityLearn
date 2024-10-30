package com.spring.Dto.UserAuthDtos;

import com.spring.Entity.AuthUser;

/**
 * Dto with the needed information of the user
 * @param id id of the user
 * @param userName name of the user
 * @param passWord password of to login*/
public record UserAuthDto (
        Long id,
        String userName,
        String passWord
) {
    public UserAuthDto(AuthUser authUser){
        this(authUser.getId(),authUser.getUserName(),authUser.getPassWord());
    }
}
