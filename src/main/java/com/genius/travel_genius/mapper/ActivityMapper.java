package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.ActivityDTO;
import com.genius.travel_genius.models.Activity;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {
    public Activity toEntity(ActivityDTO dto) {
        Activity activity = new Activity();
        activity.setActivityName(dto.getActivityName());
        activity.setActivityType(dto.getActivityType());
        activity.setGroupType(dto.getGroupType());
        return activity;
    }
    public ActivityDTO toDTO(Activity activity) {
        ActivityDTO dto = new ActivityDTO();
        dto.setActivityName(activity.getActivityName());
        dto.setActivityType(activity.getActivityType());
        dto.setGroupType(activity.getGroupType());
        return dto;
    }
}
