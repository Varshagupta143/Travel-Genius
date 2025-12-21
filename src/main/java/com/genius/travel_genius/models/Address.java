package com.genius.travel_genius.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private int houseNo;
    private String streetName;
    private String area;
    private String city;
    private String state;
    private int pinCode;
}
