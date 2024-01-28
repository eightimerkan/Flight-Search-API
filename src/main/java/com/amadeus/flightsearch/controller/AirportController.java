    package com.amadeus.flightsearch.controller;

    import com.amadeus.flightsearch.entitys.Airport;
    import com.amadeus.flightsearch.services.AirportService;
    import io.swagger.annotations.Api;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/api/airports")
    public class AirportController {
        private final AirportService airportService;

        @Autowired
        public AirportController(AirportService airportService) {
            this.airportService = airportService;
        }

        @GetMapping
        public List<Airport> getAllAirports() {
            return airportService.getAllAirports();
        }

        @GetMapping("/{id}")
        public Airport getAirportById(@PathVariable Long id) {
            return airportService.getAirportById(id);
        }

        @PostMapping
        public Airport saveAirport(@RequestBody Airport airport) {
            return airportService.saveAirport(airport);
        }

        @PutMapping("/{id}")
        public Airport updateAirport(@PathVariable Long id, @RequestBody Airport airport) {
            Airport existingAirport = airportService.getAirportById(id);
            if (existingAirport != null) {
                existingAirport.setCity(airport.getCity());
                return airportService.saveAirport(existingAirport);
            }
            return null;
        }

        @DeleteMapping("/{id}")
        public void deleteAirport(@PathVariable Long id) {
            airportService.deleteAirport(id);
        }
    }
