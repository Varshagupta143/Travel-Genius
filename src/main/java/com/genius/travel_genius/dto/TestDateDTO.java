package com.genius.travel_genius.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestDateDTO {
    @NotNull(message = "DOB is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
}
