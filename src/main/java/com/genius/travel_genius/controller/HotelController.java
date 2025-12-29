package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.HotelDTO;
import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final HotelService hotelService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody HotelDTO hotelDTO) {

        Hotel savedHotel = hotelService.addHotel(hotelDTO);

        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

}
