package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.Activity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubDestinationDTO {

    private String subDestinationName;
    private List<Activity> activities;
}
