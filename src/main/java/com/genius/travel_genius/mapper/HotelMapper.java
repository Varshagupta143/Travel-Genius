package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.HotelDTO;
import com.genius.travel_genius.models.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelDTO toHotelDTO(Hotel hotel){
        if (hotel == null) return null;
        return new HotelDTO(hotel.getHotelName(), hotel.getStayType(),hotel.getStarRating(), hotel.getRooms(), hotel.getHotelAmenities(),hotel.getAddress());
    }

    public Hotel toHotelEntity(HotelDTO dto) {
        if (dto == null) return null;

        Hotel hotel = new Hotel();
        hotel.setHotelName(dto.getHotelName());
        hotel.setStayType(dto.getStayType());
        hotel.setStarRating(dto.getStarRating());
        hotel.setRooms(dto.getRooms());
        hotel.setHotelAmenities(dto.getHotelAmenities());
        hotel.setAddress(dto.getAddress());

        return hotel;
    }
}
