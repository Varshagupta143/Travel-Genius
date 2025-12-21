package com.genius.travel_genius.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomType {
    private int occupancy;
    private int cost;
    private Services services;

}
