package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Pojazd;
import com.example.masfinalbackend.enums.VechicleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PojazdRepo extends JpaRepository<Pojazd, Long> {

    List<Pojazd> findByStan(VechicleState stan);
}
