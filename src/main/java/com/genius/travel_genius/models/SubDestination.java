package com.genius.travel_genius.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "sub_destination")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubDestination extends BaseEntity {

    private String subDestinationName;
    @DBRef
    private List<Activity> activities;
}
