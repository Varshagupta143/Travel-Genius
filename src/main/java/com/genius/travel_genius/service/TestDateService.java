package com.genius.travel_genius.service;

import com.genius.travel_genius.dto.TestDateDTO;
import com.genius.travel_genius.mapper.TestDateMapper;
import com.genius.travel_genius.models.TestDate;
import com.genius.travel_genius.repository.TestDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDateService {

    private final TestDateRepository repository;
    private final TestDateMapper mapper;

    public TestDateService(TestDateRepository repository,
                           TestDateMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TestDate saveDate(TestDateDTO dto) {
        TestDate entity = mapper.toEntity(dto);
        return repository.save(entity);
    }
    public List<TestDate> getAllDates() {
        return repository.findAll();
    }
}
