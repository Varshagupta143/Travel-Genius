package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.ActivityType;
import com.genius.travel_genius.models.GroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFilterDTO {
    private String destinationName; // destination instead of location
    private GroupType groupType;
    private ActivityType activityType;
}

