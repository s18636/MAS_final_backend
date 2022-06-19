package com.example.masfinalbackend.repository;

import com.example.masfinalbackend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}
