package com.genius.travel_genius.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel {
    private String id;
    private StayType stayType;
    private int starRating;
    private RoomType roomType;
    private HotelAmenities hotelAmenities;
    private Address address;
    private Location location;
}
