package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Dostawa;
import com.example.masfinalbackend.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DostawaRepo extends JpaRepository<Dostawa, Long> {

    @Query("select d from dostawa d where d.status = 'UTWORZONA' or d.status = 'MODYFIKOWANA' ")
    List<Dostawa> getAllReady();
}
