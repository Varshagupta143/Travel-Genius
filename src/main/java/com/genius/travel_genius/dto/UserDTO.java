package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.ActivityType;
import com.genius.travel_genius.models.Gender;
import com.genius.travel_genius.models.MaritalStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        private String username;
        private Long mobileNumber;
        private String email;
        private String password;
        private Gender gender;
        private MaritalStatus maritalStatus;
        private List<ActivityType> preferences;
}
