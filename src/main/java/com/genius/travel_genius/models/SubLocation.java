package com.genius.travel_genius.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SubLocation {
    private String id;
    private String name;
    private Location location;
    private List<Activity> activities;
}
