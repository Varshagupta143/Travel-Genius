package com.genius.travel_genius.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
        private String username;
        private Long mobileNumber;
        private String email;
        private String password;
}
