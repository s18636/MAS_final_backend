package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Pracownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownikRepo extends JpaRepository<Pracownik, Long> {}
