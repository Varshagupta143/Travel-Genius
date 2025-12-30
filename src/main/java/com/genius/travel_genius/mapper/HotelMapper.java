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
        if(dto.getHotelName() != null)
            hotel.setHotelName(dto.getHotelName());
        if(dto.getStayType() != null)
            hotel.setStayType(dto.getStayType());
        if(dto.getStarRating() != null)
            hotel.setStarRating(dto.getStarRating());
        if(dto.getRooms() != null)
            hotel.setRooms(dto.getRooms());
        if(dto.getHotelAmenities() != null)
            hotel.setHotelAmenities(dto.getHotelAmenities());
        if(dto.getAddress() != null)
            hotel.setAddress(dto.getAddress());
        return hotel;
    }
}
