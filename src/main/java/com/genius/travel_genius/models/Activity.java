package com.genius.travel_genius.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Activity {
    private String id;
    private SubLocation subLocation;
    private ActivityType activityType;
    private GroupType groupType;
}
