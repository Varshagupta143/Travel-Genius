package com.genius.travel_genius.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {


    @Email
    private String email;
    @Size(min = 10, max = 10, message = "Mobile number must be exactly 10 digits")
    private String mobileNumber;
    @NotBlank(message = "Password is required")
    private String password;
    @AssertTrue(message = "Either email or mobile number must be provided")
    public boolean isEmailOrMobilePresent() {
        return (email != null && !email.isBlank()) ||
                (mobileNumber != null && !mobileNumber.isBlank());
    }
      
}
