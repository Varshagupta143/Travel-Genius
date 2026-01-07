package com.genius.travel_genius.dto;

import com.genius.travel_genius.models.GroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchInputDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private GroupType groupType;
}
