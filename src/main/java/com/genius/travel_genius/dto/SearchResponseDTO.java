package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.ActivityType;
import com.genius.travel_genius.models.GroupType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponseDTO {
    private String destinationName;
    private GroupType groupType;
    private ActivityType activityType;
    private List<String> subDestinations;
}
