package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.ActivityDTO;
import com.genius.travel_genius.models.Activity;
import com.genius.travel_genius.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }
    @PostMapping("/add")
    public ResponseEntity<Activity> addActivity(@RequestBody ActivityDTO dto) {
        Activity activity = activityService.addActivity(dto);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Activity> updateActivity(
            @PathVariable String id,
            @RequestBody ActivityDTO dto) {
        Activity activity = activityService.updateActivity(id, dto);
        return ResponseEntity.ok(activity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable String id) {
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Activity deleted");
    }
    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return ResponseEntity.ok(activities);
    }
}
