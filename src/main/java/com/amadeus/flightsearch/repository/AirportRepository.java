package com.amadeus.flightsearch.repository;

import com.amadeus.flightsearch.entitys.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
