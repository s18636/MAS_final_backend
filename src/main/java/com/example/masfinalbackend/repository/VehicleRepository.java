package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Vehicle;
import com.example.masfinalbackend.enums.VechicleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByState(VechicleState state);
}