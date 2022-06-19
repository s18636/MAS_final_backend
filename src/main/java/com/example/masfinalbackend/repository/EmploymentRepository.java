package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Employment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {}