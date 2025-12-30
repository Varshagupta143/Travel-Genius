package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.DestinationDTO;
import com.genius.travel_genius.mapper.DestinationMapper;
import com.genius.travel_genius.mapper.HotelMapper;
import com.genius.travel_genius.mapper.SubDestinationMapper;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.models.SubDestination;
import com.genius.travel_genius.repository.DestinationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DestinationService {

    @Autowired
    private final DestinationRepository destinationRepository;
    @Autowired
    private DestinationMapper destinationMapper;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelMapper hotelMapper;
    @Autowired
    private SubDestinationService subDestinationService;
    @Autowired
    private SubDestinationMapper subDestinationMapper;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }
    public Destination addDestination(DestinationDTO destinationDTO) {
        Destination destination =  destinationMapper.toDestinationEntity(destinationDTO);
        List<SubDestination> subDestinations = new ArrayList<>();
        List<Hotel> hotels = new ArrayList<>();
        for(SubDestination subDestination: destination.getSubDestinations()){
            subDestinations.add(subDestinationService.addSubDestination(subDestinationMapper.toSubDestinationDTO(subDestination)));
        }
        for (Hotel hotel: destination.getHotels()){
            hotels.add(hotelService.addHotel(hotelMapper.toHotelDTO(hotel)));
        }
        destination.setSubDestinations(subDestinations);
        destination.setHotels(hotels);
        return destinationRepository.save(destination);
    }

    public Destination updateHotelsInDestination(String destinationId, List<Hotel> hotels) {

        Destination destination = destinationRepository.findDestinationById(destinationId);
        destination.setHotels(hotels);
        return destinationRepository.save(destination);
    }
}
