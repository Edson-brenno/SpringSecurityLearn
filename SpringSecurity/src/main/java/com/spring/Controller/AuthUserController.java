package com.spring.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.spring.Service.AuthUserService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import com.spring.Dtos.AuthUserDtos.*;

@Controller
@RequestMapping("/users")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @GetMapping
    public ResponseEntity<List<AuthUserDto>> getAllUsers() {

        return ResponseEntity.ok().body(authUserService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AuthUserDto> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(authUserService.getById(id));
    }

    @PostMapping
    public ResponseEntity<AuthUserDto> createUser(HttpServletRequest request,
                                                  @RequestBody AuthUserRegisterDto authUserDto)
            throws URISyntaxException {
        AuthUserDto authUser = authUserService.createUser(authUserDto);
        String uri = request.getRequestURI() + "/" + authUser.id();

        return ResponseEntity.created(new URI(uri)).body(authUser);
    }

    @PostMapping(value = "/tt")
    public ResponseEntity<Boolean> logar(@RequestBody AuthUserLoginDto authUserLoginDto){

        return ResponseEntity.ok().body(authUserService.logarUser(authUserLoginDto));
    }
}
