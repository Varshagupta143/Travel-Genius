package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.RoomAmenities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private Integer roomNumber;
    private Integer occupancy;
    private Integer cost;
    private List<RoomAmenities> roomAmenities;
}
