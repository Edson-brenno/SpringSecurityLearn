package com.spring.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final AuthenticationManager manager;

    public AuthUserController(AuthenticationManager manager) {
        this.manager = manager;
    }

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

        Authentication token = UsernamePasswordAuthenticationToken.unauthenticated(authUserLoginDto.username(),authUserLoginDto.password());
        Authentication tt = manager.authenticate(token);

        return ResponseEntity.ok().body(tt.isAuthenticated());//.body(authUserService.logarUser(authUserLoginDto));
    }
}
