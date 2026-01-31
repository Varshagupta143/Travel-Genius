package com.genius.travel_genius.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchResult {
    private Destination destination;
    private List<SubDestination> subDestinations;
    private List<Activity> activities;
    private List<Hotel> hotels;
}
