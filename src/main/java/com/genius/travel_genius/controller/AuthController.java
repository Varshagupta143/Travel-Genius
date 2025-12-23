package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.UserDTO;
import com.genius.travel_genius.models.User;
import com.genius.travel_genius.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO){
        User user = authService.registerUser(userDTO);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = authService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
