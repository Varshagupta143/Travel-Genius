package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.SearchFilterDTO;
import com.genius.travel_genius.dto.SearchResponseDTO;
import com.genius.travel_genius.mapper.SearchResponseMapper;
import com.genius.travel_genius.models.Activity;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.models.SubDestination;
import com.genius.travel_genius.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {

    private final DestinationRepository destinationRepository;
    private final SearchResponseMapper searchResponseMapper;

    public SearchService(DestinationRepository destinationRepository,
                         SearchResponseMapper searchResponseMapper) {
        this.destinationRepository = destinationRepository;
        this.searchResponseMapper = searchResponseMapper;
    }

    public List<SearchResponseDTO> search(SearchFilterDTO filter) {

        List<Destination> destinations =
                destinationRepository.findByDestinationNameIgnoreCase(filter.getDestinationName());




        List<SearchResponseDTO> result = new ArrayList<>();

        for (Destination destination : destinations) {
            if (destination == null || destination.getSubDestinations() == null) continue;

            List<String> subNames = new ArrayList<>();

            for (SubDestination sub : destination.getSubDestinations()) {
                if (matchesFilter(sub, filter)) {
                    subNames.add(sub.getSubDestinationName());
                }
            }

            if (subNames.isEmpty()) continue;

            result.add(searchResponseMapper.toDTO(destination, filter, subNames));

        }

        return result;
    }

    private boolean matchesFilter(SubDestination sub, SearchFilterDTO filter) {
        if (sub == null || sub.getActivities() == null) return false;

        for (Activity activity : sub.getActivities()) {
            if (activity.getActivityType() == filter.getActivityType()
                    && activity.getGroupType() == filter.getGroupType()) {
                return true;
            }
        }
        return false;
    }
}
