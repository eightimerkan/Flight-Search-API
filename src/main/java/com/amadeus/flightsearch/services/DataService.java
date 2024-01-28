package com.amadeus.flightsearch.services;
import com.amadeus.flightsearch.entitys.Airport;
import com.amadeus.flightsearch.entitys.Flight;
import com.amadeus.flightsearch.repository.AirportRepository;
import com.amadeus.flightsearch.repository.FlightRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DataService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @PostConstruct
    public void init() {
        Airport istanbulAirport = new Airport("IST", "Istanbul");
        Airport newyorkAirport = new Airport("JFK", "New York");

        Flight flight1 = new Flight("TK123", istanbulAirport, newyorkAirport, "2024-01-27 12:00:00", null, 500.0);
        Flight flight2 = new Flight("TK456", newyorkAirport, istanbulAirport, "2024-02-10 18:30:00", "2024-02-17 21:45:00", 600.0);

        airportRepository.save(istanbulAirport);
        airportRepository.save(newyorkAirport);
        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }
}
