package com.genius.travel_genius.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchResultDTO {
    private DestinationDTO destination;
    private List<SubDestinationDTO> subDestinations;
    private List<ActivityDTO> activities;
    private List<HotelDTO> hotels;
}
