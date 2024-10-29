package com.spring.Service;

import com.spring.Dto.RegisterUserDto;
import com.spring.Dto.UpdateUserDto;
import com.spring.Dto.UserDto;
import com.spring.Entity.UsuarioEntity;
import com.spring.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Returns all the user that are registered on the system
    public List<UserDto> getAllUsers(){
        return usuarioRepository.findAll()
                .stream().map(UserDto::new).toList();
    }

    // Get one user by id
    public UserDto getUserById(Long id){
        return usuarioRepository.findById(id).stream()
                .map(UserDto::new)
                .findFirst()
                .orElse(null);
    }

    // register a new user on the database
    public UserDto createUser(RegisterUserDto userDto){

        UsuarioEntity newUser = new UsuarioEntity(userDto.nome(), userDto.email());

        return new UserDto(usuarioRepository.save(newUser));
    }

    public UserDto updateUser(UpdateUserDto updateUserDto){
        UsuarioEntity user = usuarioRepository.findById(updateUserDto.id()).orElse(null);

        assert user != null;
        user.setNome(updateUserDto.nome());
        user.setEmail(updateUserDto.email());

        return new UserDto(usuarioRepository.save(user));
    }

    public void deleteUserById(Long id){
        usuarioRepository.deleteById(id);
    }

    public boolean existsUserById(Long id){
        return usuarioRepository.existsById(id);
    }
}
