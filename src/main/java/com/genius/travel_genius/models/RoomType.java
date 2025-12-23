package com.genius.travel_genius.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomType extends BaseEntity{
    private int occupancy;
    private int cost;
    private RoomAmenities roomAmenities;

}
