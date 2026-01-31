package com.genius.travel_genius.mapper;

import com.genius.travel_genius.dto.SearchInputDTO;
import com.genius.travel_genius.models.SearchInput;
import org.springframework.stereotype.Component;

@Component
public class SearchInputMapper {
    public SearchInput toModel(SearchInputDTO dto) {
        if (dto == null) return null;
        SearchInput input = new SearchInput();
        input.setStartDate(dto.getStartDate());
        input.setEndDate(dto.getEndDate());
        input.setGroupType(dto.getGroupType());
        return input;
    }
}
