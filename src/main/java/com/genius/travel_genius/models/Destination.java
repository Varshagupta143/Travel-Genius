package com.genius.travel_genius.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "destination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Destination extends BaseEntity{

    private String destinationName;
    @DBRef
    private List<SubDestination> subDestinationList;
    @DBRef
    private List<Hotel> hotels;
}
