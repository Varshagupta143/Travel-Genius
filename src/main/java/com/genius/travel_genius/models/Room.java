package com.genius.travel_genius.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "room")
public class Room extends BaseEntity{
    private int roomNumber;
    private int occupancy;
    private int cost;
    private List<RoomAmenities> roomAmenities;

}
