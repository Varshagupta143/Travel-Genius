package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.SearchInputDTO;
import com.genius.travel_genius.dto.SearchResultDTO;
import com.genius.travel_genius.mapper.SearchInputMapper;
import com.genius.travel_genius.mapper.SearchResultMapper;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.models.GroupType;
import com.genius.travel_genius.models.SearchInput;
import com.genius.travel_genius.models.SearchResult;
import com.genius.travel_genius.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

        @Service
        public class SearchService {
            @Autowired
            private DestinationRepository destinationRepository;
            @Autowired
            private SearchInputMapper searchInputMapper;
            @Autowired
            private SearchResultMapper searchResultMapper;
            public List<SearchResultDTO> search(SearchInputDTO inputDTO) {

                GroupType groupType = inputDTO.getGroupType();

                return destinationRepository.findAll().stream()
                        .filter(dest -> dest.getSubDestinations().stream()
                                .anyMatch(sub -> sub.getActivities().stream()
                                        .anyMatch(a -> a.getGroupType() == groupType)
                                )
                        )
                        .map(dest -> buildSearchResult(dest, groupType))
                        .map(searchResultMapper::toDTO)
                        .toList();
            }
            private SearchResult buildSearchResult(Destination destination, GroupType groupType) {

                SearchResult result = new SearchResult();
                result.setDestination(destination);
                  result.setSubDestinations(
                        destination.getSubDestinations().stream()
                                .map(sub -> {
                                    sub.setActivities(
                                            sub.getActivities().stream()
                                                    .filter(a -> a.getGroupType() == groupType)
                                                    .toList()
                                    );
                                    return sub;
                                })
                                .filter(sub -> !sub.getActivities().isEmpty()) // remove empty subs
                                .toList()
                );
                result.setHotels(destination.getHotels());
                return result;
            }

        }



