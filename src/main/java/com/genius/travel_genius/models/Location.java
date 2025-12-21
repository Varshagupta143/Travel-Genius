package com.genius.travel_genius.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Location {
    private String id;
    private String name;
    private List<SubLocation> subLocationList;
    private List<Hotel> hotels;
}
