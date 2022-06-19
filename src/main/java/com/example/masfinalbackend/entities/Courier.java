package com.example.masfinalbackend.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "courier")
public class Courier extends Employee {

    public Courier() {
    }

    public Courier(String name, String surname, String idSeries, List<DrivingLicenseCategory> drivingLicenseCategories) {
        super(name, surname, idSeries);
        this.drivingLicenseCategories = drivingLicenseCategories;
    }

    @OneToMany(mappedBy = "courier")
    private List<DrivingLicenseCategory> drivingLicenseCategories;

    @OneToMany
    @JoinColumn(name = "delivery_id")
    private List<Delivery> deliveries;

    public List<DrivingLicenseCategory> getDrivingLicenseCategories() {
        return drivingLicenseCategories;
    }

    public void setDrivingLicenseCategories(List<DrivingLicenseCategory> drivingLicenseCategories) {
        this.drivingLicenseCategories = drivingLicenseCategories;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
