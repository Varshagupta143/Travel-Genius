package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.models.SubDestination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {
    private String destinationName;
    private List<SubDestination> subDestinations;
    private List<Hotel> hotels;
}
