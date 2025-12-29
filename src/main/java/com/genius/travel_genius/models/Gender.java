package com.genius.travel_genius.models;

public enum Gender {
    MALE("male") , FEMALE("female");

    private final String gender;
    Gender(String gender) {
        this.gender = gender;
    }
}
