package com.genius.travel_genius.controller;

import com.genius.travel_genius.dto.TestDateDTO;
import com.genius.travel_genius.models.TestDate;
import com.genius.travel_genius.service.TestDateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DateTestController {
    private final TestDateService testDateService;
    public DateTestController(TestDateService service) {
        this.testDateService = service;
    }
    @PostMapping("/login")
    public ResponseEntity<TestDate> login(@Valid @RequestBody TestDateDTO testDateDTO) {
        TestDate savedDate = testDateService.saveDate(testDateDTO);

        return new ResponseEntity<>(savedDate, HttpStatus.OK);
    }
    @GetMapping("/dates")
    public ResponseEntity<List<TestDate>> getAllDates() {
        return ResponseEntity.ok(testDateService.getAllDates());
    }
}
