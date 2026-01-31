package com.genius.travel_genius.repository;

import com.genius.travel_genius.models.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends MongoRepository<Destination,String> {
    List<Destination> findByDestinationNameIgnoreCase(String destinationName);

}

