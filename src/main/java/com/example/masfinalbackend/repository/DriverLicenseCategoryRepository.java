package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.DrivingLicenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverLicenseCategoryRepository extends JpaRepository<DrivingLicenseCategory, Long> {}