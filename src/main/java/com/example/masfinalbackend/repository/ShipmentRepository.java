package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {}