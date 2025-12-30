package com.genius.travel_genius.repository;

import com.genius.travel_genius.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, String> {
    void removeAddressById(String id);
}

