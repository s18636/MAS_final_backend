package com.example.masfinalbackend.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name="address")
public class Address {

    public Address() {
    }
    public Address(String road, String apartmentNr, String postalCode, String city) {
        this.street = road;
        this.apartmentNumber = apartmentNr;
        this.postalCode = postalCode;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adress_id;

    public void setAdress_id(Long id) {
        this.adress_id = id;
    }
    public Long getAdress_id() {
        return adress_id;
    }

    private String street;

    private String apartmentNumber;

    private String postalCode;

    private String city;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "senderAddress")
    private List<Shipment> outgoingMail;

    @OneToMany(mappedBy = "recipientAddress")
    private List<Shipment> incomingMail;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    //>>>>>>>>
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Shipment> getOutgoingMail() {
        return outgoingMail;
    }

    public void setOutgoingMail(List<Shipment> outgoingMail) {
        this.outgoingMail = outgoingMail;
    }

    public List<Shipment> getIncomingMail() {
        return incomingMail;
    }

    public void setIncomingMail(List<Shipment> incomingMail) {
        this.incomingMail = incomingMail;
    }
}
