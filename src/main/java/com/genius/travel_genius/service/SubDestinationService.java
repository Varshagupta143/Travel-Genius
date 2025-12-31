package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.SubDestinationDTO;
import com.genius.travel_genius.mapper.SubDestinationMapper;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.models.SubDestination;
import com.genius.travel_genius.repository.ActivityRepository;
import com.genius.travel_genius.repository.SubDestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<SubDestination> getAllSubDestinations() {
        return subDestinationRepository.findAll();
    }
    public void deleteSubDestination(String id) {
        if (!subDestinationRepository.existsById(id)) {
            throw new RuntimeException("SubDestination not found");
        }
        subDestinationRepository.deleteById(id);
    }
    public SubDestination updateSubDestination(String id, SubDestinationDTO subDestinationDTO) {

        SubDestination existing = subDestinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubDestination not found"));

        existing.setSubDestinationName(subDestinationDTO.getSubDestinationName());
        existing.setActivities(subDestinationDTO.getActivities());

        return subDestinationRepository.save(existing);
    }


}
