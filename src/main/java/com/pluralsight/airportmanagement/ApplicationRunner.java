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
@Order(2)
public class ApplicationRunner implements CommandLineRunner {
    private FlightInformationRepository flightRepository;
    private AirportRepository airportRepository;

    public ApplicationRunner(FlightInformationRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void run(String... args) {
        // Single update point
        Airport rome = this.airportRepository.findById("1d1aab22-670b-48cb-a027-721e2055731f").get();
        rome.setName("Leonardo da Vinci (Fiumicino)");
        this.airportRepository.save(rome);

        System.out.println("-> AFTER UPDATE TO ROME AIRPORT");
        List<FlightInformation> flights = this.flightRepository.findAll();
        FlightPrinter.print(flights);
    }
}