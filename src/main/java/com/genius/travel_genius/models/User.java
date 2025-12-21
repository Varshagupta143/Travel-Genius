package com.genius.travel_genius.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class User {

    private String id;
    private String name;
    private Integer mobileNumber;
    private String email;
    private String password;
    private Gender gender;
    private MaritalStatus maritalStatus;
    private List<String>  preferences;

}
