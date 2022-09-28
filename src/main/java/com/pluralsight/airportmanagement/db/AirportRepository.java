package com.pluralsight.airportmanagement.db;

import com.pluralsight.airportmanagement.domain.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String> {
}
