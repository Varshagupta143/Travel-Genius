package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.RoomDTO;
import com.genius.travel_genius.models.Room;
import com.genius.travel_genius.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody RoomDTO roomDTO) {
        return new ResponseEntity<>(roomService.addRoom(roomDTO), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room>rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable String id, @RequestBody RoomDTO roomDTO) {
       Room room = roomService.updateRoom(id,roomDTO);
        return new ResponseEntity<>(room,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok("Room deleted successfully");
    }

}
