package com.genius.travel_genius.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

    private int houseNo;
    private String streetName;
    private String area;
    private String city;
    private String state;
    private int pinCode;
}
