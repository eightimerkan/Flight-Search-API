package com.amadeus.flightsearch.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.apache.tomcat.util.json.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@ApiModel(value = "Flight Classim",description = "Uçuşa ait bilgiler")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@ApiModelProperty(value = "Uçuşa ait tekil id alani")
    private Long id;

    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    //@ApiModelProperty(value = "Uçuşa ait tekil kalkış havaalanı")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    //@ApiModelProperty(value = "Uçuşa ait tekil iniş havaalanı")
    private Airport arrivalAirport;

    //@ApiModelProperty(value = "Uçuşa ait tekil kalkış zamanı")
    private Date departureDateTime;
    //@ApiModelProperty(value = "Uçuşa ait tekil dönüş zamanı")
    private Date returnDateTime;
    private Double price;

    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport, String departureDateTime, String returnDateTime, Double price) {
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = parseDateTime(departureDateTime);
        this.returnDateTime = (returnDateTime != null) ? parseDateTime(returnDateTime) : null;
        this.price = price;
    }

    public Date parseDateTime(String dateTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Date parseDate(String dateTime) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateTime);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
