package com.genius.travel_genius.repository;

import com.genius.travel_genius.models.Destination;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends MongoRepository<Destination,String> {
}
