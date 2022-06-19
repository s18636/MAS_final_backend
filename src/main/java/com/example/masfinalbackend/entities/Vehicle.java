package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.VechicleState;
import com.example.masfinalbackend.enums.VechicleType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "vehicle")
public class Vehicle {

    private static Set<String> registrationNumbers;

    public Vehicle() {}

    public Vehicle(String registrationNumber, String manufacturer, String model, VechicleType type){
        this.registrationNumber = registrationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.type = type;
        this.state = VechicleState.GOTOWY;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicle_id;

    public void setVehicle_id(Long id) {
        this.vehicle_id = id;
    }
    public Long getVehicle_id() {
        return vehicle_id;
    }

    //unique
    private String registrationNumber;

    private String manufacturer;

    private String model;

    @OneToMany(mappedBy = "vehicle")
    private List<Delivery> deliveries;

    @Enumerated
    private VechicleType type;

    @Enumerated
    private VechicleState state;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public VechicleType getType() {
        return type;
    }

    public void setType(VechicleType typ) {
        this.type = typ;
    }

    public VechicleState getState() {
        return state;
    }

    public void setState(VechicleState state) {
        this.state = state;
    }

    public static Set<String> getRegistrationNumbers() {
        return registrationNumbers;
    }

    public static void setRegistrationNumbers(Set<String> registrationNumbers) {
        Vehicle.registrationNumbers = registrationNumbers;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
