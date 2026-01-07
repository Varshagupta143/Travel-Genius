package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.SearchResultDTO;
import com.genius.travel_genius.models.SearchResult;
import org.springframework.stereotype.Component;

@Component
public class SearchResultMapper {
    private final DestinationMapper destinationMapper;
    private final SubDestinationMapper subDestinationMapper;
    private final ActivityMapper activityMapper;
    private final HotelMapper hotelMapper;
    public SearchResultMapper(DestinationMapper destinationMapper,
                              SubDestinationMapper subDestinationMapper,
                              ActivityMapper activityMapper,
                              HotelMapper hotelMapper) {
        this.destinationMapper = destinationMapper;
        this.subDestinationMapper = subDestinationMapper;
        this.activityMapper = activityMapper;
        this.hotelMapper = hotelMapper;
    }
    public SearchResultDTO toDTO(SearchResult result) {
        if (result == null) return null;
        SearchResultDTO dto = new SearchResultDTO();
        dto.setDestination(destinationMapper.toDestinationDTO(result.getDestination()));
        dto.setSubDestinations(
                result.getSubDestinations().stream()
                        .map(subDestinationMapper::toSubDestinationDTO)
                        .toList()
        );
        dto.setActivities(
                result.getSubDestinations().stream()
                        .flatMap(sub -> sub.getActivities().stream())
                        .map(activityMapper::toDTO)
                        .toList()
        );
        dto.setHotels(
                result.getHotels().stream()
                        .map(hotelMapper::toHotelDTO)
                        .toList()
        );
        return dto;
    }

    }
