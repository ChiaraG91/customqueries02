package com.customqueries02.customqueries02.services;

import com.customqueries02.customqueries02.entities.Flight;
import com.customqueries02.customqueries02.entities.enums.StatusEnum;
import com.customqueries02.customqueries02.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;
    Random random = new Random();
     private StatusEnum randomStatus() {
        String[] statuses = {"ONTIME", "DELAYED", "CANCELLED"};
        return StatusEnum.valueOf(statuses[random.nextInt(statuses.length)]);
    }

    public List<Flight> provFlights() {
        for (int i = 0; i < 500; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport("Airport " + i);
            flight.setToAirport("Airport " + (i + 1));
            flight.setStatusEnum(randomStatus());
            flightRepository.save(flight);
        }
        return flightRepository.findAll();
    }
    public List<Flight> getAllFlights(){
        List<Flight> flights = flightRepository.findAll();
        return flights;
    }

    public Optional<Flight> getFlight(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        return flightOptional;
    }

}
