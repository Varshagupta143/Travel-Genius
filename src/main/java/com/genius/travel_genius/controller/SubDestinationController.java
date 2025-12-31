package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.DestinationDTO;
import com.genius.travel_genius.dto.SubDestinationDTO;
import com.genius.travel_genius.mapper.DestinationMapper;
import com.genius.travel_genius.mapper.SubDestinationMapper;
import com.genius.travel_genius.models.Destination;
import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.models.SubDestination;
import com.genius.travel_genius.service.DestinationService;
import com.genius.travel_genius.service.SubDestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subdestination")
public class SubDestinationController {
    private final SubDestinationService subDestinationService;
    private final SubDestinationMapper subDestinationMapper;
    public SubDestinationController(SubDestinationService subDestinationService,
                                    SubDestinationMapper subDestinationMapper) {
        this.subDestinationService = subDestinationService;
        this.subDestinationMapper = subDestinationMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<SubDestination> addSubDestination(@RequestBody SubDestinationDTO subDestinationDTO) {
        return new ResponseEntity<>(subDestinationService.addSubDestination(subDestinationDTO), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<SubDestination>> getAllSubDestinations() {
        return ResponseEntity.ok(subDestinationService.getAllSubDestinations());
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<SubDestination> updateSubDestination(
            @PathVariable String id,
            @RequestBody SubDestinationDTO subDestinationDTO) {
        return ResponseEntity.ok(subDestinationService.updateSubDestination(id, subDestinationDTO)
        );
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubDestination(@PathVariable String id) {
        subDestinationService.deleteSubDestination(id);
        return ResponseEntity.ok("SubDestination deleted successfully");
    }

}
