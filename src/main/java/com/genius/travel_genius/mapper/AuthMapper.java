package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.AuthDTO;
import com.genius.travel_genius.models.User;
import org.springframework.stereotype.Component;

@Component

public class AuthMapper {
    public User toEntity(AuthDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
