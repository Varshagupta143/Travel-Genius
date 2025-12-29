package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.DestinationDTO;
import com.genius.travel_genius.models.Destination;
import org.springframework.stereotype.Component;

@Component
public class DestinationMapper {

    public DestinationDTO toDestinationDTO(Destination destination){
        if (destination == null) return null;
        return new DestinationDTO(destination.getDestinationName(), destination.getSubDestinations(),
                destination.getHotels());
    }

    public Destination toDestinationEntity(DestinationDTO destinationDTO){
        if (destinationDTO == null) return null;

        Destination destination = new Destination();
        destination.setDestinationName(destinationDTO.getDestinationName());
        destination.setSubDestinations(destinationDTO.getSubDestinations());
        destination.setHotels(destinationDTO.getHotels());
        return destination;
    }
}
