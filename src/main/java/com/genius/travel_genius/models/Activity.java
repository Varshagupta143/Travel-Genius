package com.genius.travel_genius.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity extends BaseEntity {

    private String activityName;
    private ActivityType activityType;
    private GroupType groupType;
}
