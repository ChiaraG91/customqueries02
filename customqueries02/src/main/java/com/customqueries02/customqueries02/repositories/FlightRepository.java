package com.customqueries02.customqueries02.repositories;

import com.customqueries02.customqueries02.entities.Flight;
import com.customqueries02.customqueries02.entities.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {


    List<Flight> findByStatusEnum(StatusEnum statusEnum);



}
