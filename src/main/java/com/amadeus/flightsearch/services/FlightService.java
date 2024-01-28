package com.amadeus.flightsearch.services;

import com.amadeus.flightsearch.entitys.Airport;
import com.amadeus.flightsearch.entitys.Flight;
import com.amadeus.flightsearch.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


    public List<Flight> searchOneWayFlights(Long departureCity, Long arrivalCity, String departureDate) {
         Flight flight = new Flight();
         Airport departure = new Airport();
         Airport arrival = new Airport();

         departure.setId(departureCity);
         arrival.setId(arrivalCity);

        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setDepartureDateTime(flight.parseDateTime(departureDate));

        return flightRepository.findAll(Example.of(flight));
    }

    public List<Flight> searchRoundTripFlights(Long departureCity, Long arrivalCity, String departureDate, String returnDate) {
        Flight flight = new Flight();
        Airport departure = new Airport();
        Airport arrival = new Airport();

        departure.setId(departureCity);
        arrival.setId(arrivalCity);

        flight.setDepartureAirport(departure);
        flight.setArrivalAirport(arrival);
        flight.setDepartureDateTime(flight.parseDateTime(departureDate));
        flight.setReturnDateTime(flight.parseDateTime(returnDate));

        return flightRepository.findAll(Example.of(flight));
    }

}
