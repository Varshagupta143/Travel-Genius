package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.UserDTO;
import com.genius.travel_genius.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toRegistrationDto(User user) {
        if (user == null) return null;
        return new UserDTO(user.getName(), user.getMobileNumber(), user.getEmail(), user.getPassword());
    }

    public User toUserEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setName(dto.getUsername());
        user.setMobileNumber(dto.getMobileNumber());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
