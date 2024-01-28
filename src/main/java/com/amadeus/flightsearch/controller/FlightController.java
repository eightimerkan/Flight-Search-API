package com.amadeus.flightsearch.controller;

import com.amadeus.flightsearch.entitys.Flight;
import com.amadeus.flightsearch.services.FlightService;
import com.amadeus.flightsearch.repository.FlightRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    @PostConstruct
    public void init(){}
    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    public Flight saveFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight existingFlight = flightService.getFlightById(id);
        if (existingFlight != null) {
            existingFlight.setDepartureAirport(flight.getDepartureAirport());
            existingFlight.setArrivalAirport(flight.getArrivalAirport());
            existingFlight.setDepartureDateTime(flight.getDepartureDateTime());
            existingFlight.setReturnDateTime(flight.getReturnDateTime());
            existingFlight.setPrice(flight.getPrice());
            return flightService.saveFlight(existingFlight);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }


    @GetMapping("/search")
    public List<Flight> searchFlights(@RequestParam Long departureCity,
                                      @RequestParam Long arrivalCity,
                                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String departureDate,
                                      @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String returnDate) {
        if (returnDate == null) {
            return flightService.searchOneWayFlights(departureCity, arrivalCity, departureDate);
        } else {
            return flightService.searchRoundTripFlights(departureCity, arrivalCity, departureDate, returnDate);
        }
    }
}
