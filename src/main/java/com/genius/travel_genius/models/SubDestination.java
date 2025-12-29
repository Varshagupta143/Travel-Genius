package com.genius.travel_genius.models;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
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
