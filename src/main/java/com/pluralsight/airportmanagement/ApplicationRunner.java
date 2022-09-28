package com.pluralsight.airportmanagement;

import com.pluralsight.airportmanagement.db.AirportRepository;
import com.pluralsight.airportmanagement.db.FlightInformationRepository;
import com.pluralsight.airportmanagement.domain.Airport;
import com.pluralsight.airportmanagement.domain.FlightInformation;
import com.pluralsight.airportmanagement.domain.FlightPrinter;
import com.pluralsight.airportmanagement.queries.FlightInformationQueries;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
public class ApplicationRunner implements CommandLineRunner {
    private FlightInformationRepository flightRepository;

    public ApplicationRunner(FlightInformationRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) {
        List<FlightInformation> flights = this.flightRepository.findAll();
        FlightPrinter.print(flights);
    }
}