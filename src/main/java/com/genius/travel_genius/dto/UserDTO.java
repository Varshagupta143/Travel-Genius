package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.ActivityType;
import com.genius.travel_genius.models.Gender;
import com.genius.travel_genius.models.MaritalStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        @NotBlank(message = "Name is required")
        private String username;
        @NotBlank(message = "Mobile number is required")
        @Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits")
        private String mobileNumber;
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        private String email;
        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        private String password;
        private Gender gender;
        private MaritalStatus maritalStatus;
        private List<ActivityType> preferences;
}
