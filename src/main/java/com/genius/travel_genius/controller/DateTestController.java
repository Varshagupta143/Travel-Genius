package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.TestDateDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DateTestController {
    @PostMapping("/login")   // using same mapping style
    public ResponseEntity<String> login(@Valid @RequestBody TestDateDTO testDateDTO) {
        String result = "Received date: " + testDateDTO.getDob();
        return ResponseEntity.ok(result);
    }
}
