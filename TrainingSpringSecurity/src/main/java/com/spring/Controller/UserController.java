package com.spring.Controller;

import com.spring.Dto.RegisterUserDto;
import com.spring.Dto.UpdateUserDto;
import com.spring.Dto.UserDto;
import com.spring.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {

        if (!userService.existsUserById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(HttpServletRequest request, @RequestBody RegisterUserDto userDto) throws URISyntaxException {

        UserDto newUser = userService.createUser(userDto);

        String uri = request.getRequestURI() + "/" + newUser.id();

        return ResponseEntity.created(new URI(uri)).body(newUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserDto updateUserDto){

        if (!userService.existsUserById(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(userService.updateUser(updateUserDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id){

        if (!userService.existsUserById(id)){
            return ResponseEntity.notFound().build();
        }

        userService.deleteUserById(id);
        return ResponseEntity.ok().build();
    }
}
