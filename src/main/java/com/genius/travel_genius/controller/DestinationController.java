package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.DestinationDTO;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Destination> addDestination(@RequestBody DestinationDTO destinationDTO) {
        return new ResponseEntity<>(destinationService.addDestination(destinationDTO), HttpStatus.CREATED);
    }

}
