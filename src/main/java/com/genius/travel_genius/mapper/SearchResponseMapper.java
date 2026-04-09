package com.genius.travel_genius.mapper;


import com.genius.travel_genius.dto.SearchFilterDTO;
import com.genius.travel_genius.dto.SearchResponseDTO;
import com.genius.travel_genius.models.Destination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResponseMapper {

    public SearchResponseDTO toDTO(Destination destination,
                                   SearchFilterDTO filter,
                                   List<String> subNames) {

        SearchResponseDTO dto = new SearchResponseDTO();
        dto.setDestinationName(destination.getDestinationName());
        dto.setGroupType(filter.getGroupType());
        dto.setActivityType(filter.getActivityType());
        dto.setSubDestinations(subNames);
        return dto;
    }
}

