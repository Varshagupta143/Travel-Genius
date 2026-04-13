package com.genius.travel_genius.repository;

import com.genius.travel_genius.models.TestDate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface TestDateRepository extends MongoRepository<TestDate, String> {

}
