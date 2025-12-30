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

    public Hotel updateHotel(String id, HotelDTO hotelDTO){
        Hotel hotel = hotelRepository.getHotelById(id);
        if(hotelDTO.getHotelName() != null)
            hotel.setHotelName(hotelDTO.getHotelName());
        if(hotelDTO.getStayType() != null)
            hotel.setStayType(hotelDTO.getStayType());
        if(hotelDTO.getStarRating() != null)
            hotel.setStarRating(hotelDTO.getStarRating());
        if(hotelDTO.getRooms() != null) {
            hotel.setRooms(roomRepository.saveAll(hotelDTO.getRooms()));
        }
        if(hotelDTO.getHotelAmenities() != null)
            hotel.setHotelAmenities(hotelDTO.getHotelAmenities());
        if(hotelDTO.getAddress() != null) {
            String addressId = hotel.getAddress().getId();
            addressRepository.removeAddressById(addressId);
            hotel.setAddress(addressRepository.save(hotelDTO.getAddress()));
        }
        return hotelRepository.save(hotel);
    }
}
