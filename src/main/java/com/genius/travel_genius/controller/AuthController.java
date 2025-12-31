package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.LoginDTO;
import com.genius.travel_genius.dto.UserDTO;
import com.genius.travel_genius.models.User;
import com.genius.travel_genius.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@Validated
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO){
        User user = authService.registerUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {
        String result = authService.login(loginDTO);
        return ResponseEntity.ok(result);
    }
}
