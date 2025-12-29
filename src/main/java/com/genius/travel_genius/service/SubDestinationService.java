package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.SubDestinationDTO;
import com.genius.travel_genius.mapper.SubDestinationMapper;
import com.genius.travel_genius.models.SubDestination;
import com.genius.travel_genius.repository.ActivityRepository;
import com.genius.travel_genius.repository.SubDestinationRepository;
import org.springframework.stereotype.Service;

@Service
public class SubDestinationService {
    private final SubDestinationMapper subDestinationMapper;
    private final SubDestinationRepository subDestinationRepository;
    private final ActivityRepository activityRepository;

    public SubDestinationService(SubDestinationMapper subDestinationMapper, SubDestinationRepository subDestinationRepository, ActivityRepository activityRepository) {
        this.subDestinationMapper = subDestinationMapper;
        this.subDestinationRepository = subDestinationRepository;
        this.activityRepository = activityRepository;
    }

    public SubDestination addSubDestination(SubDestinationDTO subDestinationDTO){
        SubDestination subDestinationToAdd = subDestinationMapper.toSubDestinationEntity(subDestinationDTO);
        activityRepository.saveAll(subDestinationToAdd.getActivities());
        return subDestinationRepository.save(subDestinationToAdd);
    }
}
