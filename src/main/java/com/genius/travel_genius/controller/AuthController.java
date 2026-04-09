package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.AuthResponseDTO;
import com.genius.travel_genius.dto.ForgotPasswordDTO;
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
@CrossOrigin(origins = "http://localhost:5173")
@RestController

@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDTO userDTO){
        authService.registerUser(userDTO);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO) {
        AuthResponseDTO  response = authService.login(loginDTO);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@Valid @RequestBody ForgotPasswordDTO dto){

        String email = dto.getEmail();

        boolean exists = authService.checkEmailExists(email);

        if(!exists){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Email not found");
        }

        return ResponseEntity.ok("Reset link sent");
    }

}
