package com.amadeus.flightsearch.repository;

import com.amadeus.flightsearch.entitys.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}