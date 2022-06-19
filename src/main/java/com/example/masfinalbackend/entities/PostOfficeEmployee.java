package com.example.masfinalbackend.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name="postOfficeEmployee")
public class PostOfficeEmployee extends Employee {

    public PostOfficeEmployee() {}

    public PostOfficeEmployee(String name, String surname, String idSeries, String position){
        super(name, surname, idSeries);
        this.position = position;
    }

    private String position;

    @OneToMany(mappedBy = "manager")
    private List<PostOfficeEmployee> subordinates;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employee_id")
    private PostOfficeEmployee manager;

    @OneToMany(mappedBy = "acceptingEmployee")
    private List<Shipment> acceptedShipments;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<PostOfficeEmployee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<PostOfficeEmployee> subordinates) {
        this.subordinates = subordinates;
    }

    public PostOfficeEmployee getManager() {
        return manager;
    }

    public void setManager(PostOfficeEmployee manager) {
        this.manager = manager;
    }

    public List<Shipment> getAcceptedShipments() {
        return acceptedShipments;
    }

    public void setAcceptedShipments(List<Shipment> acceptedShipments) {
        this.acceptedShipments = acceptedShipments;
    }
}
