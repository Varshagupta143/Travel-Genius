package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.ActivityDTO;
import com.genius.travel_genius.exception.ResourceNotFoundException;
import com.genius.travel_genius.models.Activity;
import com.genius.travel_genius.repository.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    public Activity addActivity(ActivityDTO dto) {
        Activity activity = new Activity();
        activity.setActivityName(dto.getActivityName());
        activity.setActivityType(dto.getActivityType());
        activity.setGroupType(dto.getGroupType());
        return activityRepository.save(activity);
    }
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
    // ActivityService.java

    public Activity updateActivity(String id, ActivityDTO dto) {
        return activityRepository.findById(id)
                .map(existingActivity -> {
                    existingActivity.setActivityName(dto.getActivityName());
                    existingActivity.setActivityType(dto.getActivityType());
                    existingActivity.setGroupType(dto.getGroupType());
                    return activityRepository.save(existingActivity);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id: " + id));
    }

    public void deleteActivity(String id) {
        if (!activityRepository.existsById(id)) {
            throw new RuntimeException("ID not found: " + id);
        }
        activityRepository.deleteById(id);
    }
}
