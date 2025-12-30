package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.RoomDTO;
import com.genius.travel_genius.models.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public Room toRoomEntity(RoomDTO dto) {
        Room room = new Room();
        room.setRoomNumber(dto.getRoomNumber());
        room.setOccupancy(dto.getOccupancy());
        room.setCost(dto.getCost());
        room.setRoomAmenities(dto.getRoomAmenities());
        return room;
    }

    public RoomDTO toRoomDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setRoomNumber(room.getRoomNumber());
        dto.setOccupancy(room.getOccupancy());
        dto.setCost(room.getCost());
        dto.setRoomAmenities(room.getRoomAmenities());
        return dto;
    }
}

