package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.UserDTO;
import com.genius.travel_genius.mapper.UserMapper;
import com.genius.travel_genius.models.User;
import com.genius.travel_genius.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO){
        log.info("Mapping User dto to User entity");
        User newUser = userMapper.toUserEntity(userDTO);
        log.info("User mapped and now saving to database");
        return userRepository.save(newUser);
    }



}
