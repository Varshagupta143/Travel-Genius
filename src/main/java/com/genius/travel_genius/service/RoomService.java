package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.RoomDTO;
import com.genius.travel_genius.mapper.RoomMapper;
import com.genius.travel_genius.models.Room;
import com.genius.travel_genius.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public Room addRoom(RoomDTO roomDTO) {
        Room room = roomMapper.toRoomEntity(roomDTO);
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room updateRoom(String id, RoomDTO roomDTO) {
        Room room  = roomRepository.getRoomById(id);
        if(roomDTO.getRoomNumber() != null)
            room.setRoomNumber(roomDTO.getRoomNumber());
        if(roomDTO.getOccupancy() != null)
            room.setOccupancy(roomDTO.getOccupancy());
        if(roomDTO.getCost() != null)
            room.setCost(roomDTO.getCost());
        if(roomDTO.getRoomAmenities()!= null)
            room.setRoomAmenities(roomDTO.getRoomAmenities());
        return roomRepository.save(room);
    }

    public void deleteRoom(String id)
    {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("ID not found: " + id);
        }
        roomRepository.deleteById(id);
    }
}