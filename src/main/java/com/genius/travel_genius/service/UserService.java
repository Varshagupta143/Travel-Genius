package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.UserDTO;

import com.genius.travel_genius.models.User;
import com.genius.travel_genius.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email){
        log.info("Getting user from Database for email:" + email);
        User user = userRepository.getUserByEmail(email);
        user.setPassword("");
        return user;
    }

    public User updateUser(String email, UserDTO userDTO) {
        User userToUpdate = getUserByEmail(email);
        userToUpdate.setGender(userDTO.getGender());
        userToUpdate.setMaritalStatus(userDTO.getMaritalStatus());
        userToUpdate.setPreferences(userDTO.getPreferences());
        return userRepository.save(userToUpdate);
    }
}
