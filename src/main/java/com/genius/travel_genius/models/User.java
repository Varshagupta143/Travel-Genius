package com.genius.travel_genius.models;

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
    @NonNull
    private String name;
    @NonNull
    @Indexed(unique = true)
    private Long mobileNumber;
    @NonNull
    @Indexed(unique = true)
    private String email;
    @NonNull
    private String password;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private List<ActivityType>  preferences;

}
