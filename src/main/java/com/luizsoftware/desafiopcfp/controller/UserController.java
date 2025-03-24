package com.luizsoftware.desafiopcfp.controller;

import com.luizsoftware.desafiopcfp.dto.UserDTO;
import com.luizsoftware.desafiopcfp.exception.UserLoginException;
import com.luizsoftware.desafiopcfp.model.User;
import com.luizsoftware.desafiopcfp.dto.TokenJwtDTO;
import com.luizsoftware.desafiopcfp.repository.UserRepository;
import com.luizsoftware.desafiopcfp.security.SecurityConfig;
import com.luizsoftware.desafiopcfp.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SecurityConfig security;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserDTO data) {
        var authToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());

        var authentication = manager.authenticate(authToken);

        System.out.println(authentication);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());


        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid UserDTO data) {
        String encryptedPassword = security.passwordEncoder().encode(data.senha());

        var verifyUser = repository.findByLogin(data.login());
        if(verifyUser.isPresent()){
            throw new UserLoginException("O usuário informado já está em uso");
        }

        User user = new User(data.login(), encryptedPassword);

        repository.save(user);

        return ResponseEntity.ok().build();
    }
}
