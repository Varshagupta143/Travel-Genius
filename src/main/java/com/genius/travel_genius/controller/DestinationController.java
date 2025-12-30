package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.DestinationDTO;
import com.genius.travel_genius.mapper.DestinationMapper;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationService destinationService;
    private final DestinationMapper destinationMapper;
    public DestinationController(DestinationService destinationService,DestinationMapper destinationMapper) {
        this.destinationService = destinationService;
        this.destinationMapper = destinationMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<Destination> addDestination(@RequestBody DestinationDTO destinationDTO) {
        return new ResponseEntity<>(destinationService.addDestination(destinationDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/hotels/{destinationId}")
    public ResponseEntity<DestinationDTO> updateHotelsInDestination(@PathVariable String destinationId,
            @RequestBody List<Hotel> hotels) {
        Destination destination = destinationService.updateHotelsInDestination(destinationId, hotels);
        return ResponseEntity.ok(destinationMapper.toDestinationDTO(destination));
    }

}
