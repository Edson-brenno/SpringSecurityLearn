package com.spring.Service;

import com.spring.Entity.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.Repository.AuthUserRepository;
import com.spring.Dtos.AuthUserDtos.*;

import java.util.List;

@Service
public class AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;

    // This method it'll return all the users that are registered
    public List<AuthUserDto> getAll() {

        return authUserRepository.findAll()
                .stream().map(AuthUserDto::new).toList();
    }

    // This method it'll get one user by id
    public AuthUserDto getById(Long id) {
        return new AuthUserDto(authUserRepository.findById(id).get());
    }

    /**
     * This method is responsible to register a new user on the system
     * @param authUserRegisterDto dto with the information needed to create a new user*/
    public AuthUserDto createUser(AuthUserRegisterDto authUserRegisterDto) {
        AuthUser authUser = new AuthUser(authUserRegisterDto.username(), authUserRegisterDto.password(),
                authUserRegisterDto.firstName(), authUserRegisterDto.lastName(),
                authUserRegisterDto.email());

        return new AuthUserDto(authUserRepository.save(authUser));
    }
}
