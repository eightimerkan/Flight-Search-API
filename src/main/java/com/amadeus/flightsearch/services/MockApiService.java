package com.amadeus.flightsearch.services;

import com.amadeus.flightsearch.entitys.Airport;
import com.amadeus.flightsearch.entitys.Flight;
import com.amadeus.flightsearch.repository.AirportRepository;
import com.amadeus.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class MockApiService {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private AirportRepository airportRepository;

    public void getDataAndSaveToDatabase() {
        List<Flight> mockFlights = generateMockFlights();
        flightRepository.saveAll(mockFlights);
    }

    private List<Flight> generateMockFlights() {
        List<Flight> flights = new ArrayList<>();
        Airport istanbulAirport = airportRepository.save(new Airport("CDG", "Paris"));
        Airport newYorkAirport = airportRepository.save(new Airport("BER", "Berlin"));

        for (int i = 1; i <= 5; i++) {
            Flight flight = new Flight();
            flight.setFlightNumber("TK" + i);
            flight.setDepartureAirport(istanbulAirport);
            flight.setArrivalAirport(newYorkAirport);
            flight.setDepartureDateTime(new Date());
            flight.setReturnDateTime(new Date());
            flight.setPrice(generateRandomPrice());
            flights.add(flight);
        }

        return flights;
    }

    private double generateRandomPrice() {
        Random random = new Random();
        return 100 + (1000 - 100) * random.nextDouble();
    }
}
