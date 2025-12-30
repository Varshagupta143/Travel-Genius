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
public class ActivityDTO {
    private String activityName;
    private ActivityType activityType;
    private GroupType groupType;

}
