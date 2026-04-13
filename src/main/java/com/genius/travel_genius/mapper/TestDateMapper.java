package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.TestDateDTO;
import com.genius.travel_genius.models.TestDate;
import org.springframework.stereotype.Component;

@Component
public class TestDateMapper {
    public TestDate toEntity(TestDateDTO dto) {
        TestDate entity = new TestDate();
        entity.setDob(dto.getDob());
        return entity;
    }
    public TestDateDTO toDto(TestDate entity) {
        TestDateDTO dto = new TestDateDTO();
        dto.setDob(entity.getDob());
        return dto;
    }
}
