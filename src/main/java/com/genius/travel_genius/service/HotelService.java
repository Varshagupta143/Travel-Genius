package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.HotelDTO;
import com.genius.travel_genius.mapper.HotelMapper;
import com.genius.travel_genius.models.Hotel;
import com.genius.travel_genius.repository.AddressRepository;
import com.genius.travel_genius.repository.HotelRepository;
import com.genius.travel_genius.repository.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HotelService {
    @Autowired
    private final HotelRepository hotelRepository;
    @Autowired
    private final HotelMapper hotelMapper;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private AddressRepository addressRepository;

    public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    public Hotel addHotel(HotelDTO hotelDTO) {
        Hotel hotel = hotelMapper.toHotelEntity(hotelDTO);
        addressRepository.save(hotelDTO.getAddress());
        roomRepository.saveAll(hotelDTO.getRooms());
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
}
