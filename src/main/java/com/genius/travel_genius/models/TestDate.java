package com.genius.travel_genius.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "TestDate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestDate  extends BaseEntity{
    private LocalDate dob;
}
