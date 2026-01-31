package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {
    private String hotelName;
    private StayType stayType;
    private StarRating starRating;
    private List<Room> rooms;
    private List<HotelAmenities> hotelAmenities;
    private Address address;


}
