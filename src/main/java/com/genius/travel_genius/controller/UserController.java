package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.UserDTO;
import com.genius.travel_genius.models.User;
import com.genius.travel_genius.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService  userService) {
       this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email){
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PatchMapping("/update/{email}")
    public ResponseEntity<User> updateUser(
            @PathVariable String email,
            @RequestBody UserDTO userDTO) {

        User updatedUser = userService.updateUser(email, userDTO);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}