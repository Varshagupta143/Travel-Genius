package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.SubDestinationDTO;
import com.genius.travel_genius.models.SubDestination;
import org.springframework.stereotype.Component;

@Component
public class SubDestinationMapper {

    public SubDestination toSubDestinationEntity(SubDestinationDTO subDestinationDTO){
        if(subDestinationDTO == null) return null;
        SubDestination subDestination = new SubDestination();
        subDestination.setSubDestinationName(subDestinationDTO.getSubDestinationName());
        subDestination.setActivities(subDestinationDTO.getActivities());
        return subDestination;
    }

    public SubDestinationDTO toSubDestinationDTO(SubDestination subDestination){
        if(subDestination == null) return null;
        return new SubDestinationDTO(subDestination.getSubDestinationName(), subDestination.getActivities());
    }
}
