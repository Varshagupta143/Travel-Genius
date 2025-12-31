package com.genius.travel_genius.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document(collection = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    private String username;
    @Indexed(unique = true)
    private String mobileNumber;
    @Indexed(unique = true)
    private String email;
    private String password;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private List<ActivityType>  preferences;

}
