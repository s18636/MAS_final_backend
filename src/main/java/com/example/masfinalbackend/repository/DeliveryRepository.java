package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    @Query("select d from delivery d where d.status = 'UTWORZONA' or d.status = 'MODYFIKOWANA' ")
    List<Delivery> getAllReady();
}
