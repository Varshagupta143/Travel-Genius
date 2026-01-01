package com.genius.travel_genius.repository;

import com.genius.travel_genius.models.Gender;
import com.genius.travel_genius.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User getUserByEmail(String email);
    User getUserByMobileNumber(String mobileNumber);
}
