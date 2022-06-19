package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.DrivingLicenseCategoryCode;

import javax.persistence.*;
import java.util.Date;

@Entity(name="drivingLicenseCategory")
public class DrivingLicenseCategory {

    public DrivingLicenseCategory(){}

    public DrivingLicenseCategory(DrivingLicenseCategoryCode category, Date expirationDate) {
        this.category = category;
        this.expirationDate = expirationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    public void setCategory_id(Long id) {
        this.category_id = id;
    }
    public Long getCategory_id() {
        return category_id;
    }

    @Enumerated
    private DrivingLicenseCategoryCode category;

    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name="courier_id")
    private Courier courier;

    public DrivingLicenseCategoryCode getCategory() {
        return category;
    }

    public void setCategory(DrivingLicenseCategoryCode category) {
        this.category = category;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
