package com.spring.Service;

import com.spring.Dto.RegisterUserDto;
import com.spring.Dto.UserAuthDtos.RegisterUserAuthDto;
import com.spring.Entity.AuthUser;
import com.spring.Repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    public boolean createUser(RegisterUserAuthDto registerUserAuthDto) {
        try{
            userAuthRepository.save(new AuthUser(registerUserAuthDto.userName(), registerUserAuthDto.passWord()));

            return true;
        }catch (Exception e){
            return false;
        }
    }
}
