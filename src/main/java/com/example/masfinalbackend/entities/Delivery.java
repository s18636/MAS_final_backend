package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.DeliveryStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long delivery_id;

    public void setDelivery_id(Long id) {
        this.delivery_id = id;
    }
    public Long getDelivery_id() {
        return delivery_id;
    }

    public Delivery(){
    }

    public Delivery(Employee employee, List<Shipment> shipments) {
        this.employee = employee;
        this.shipments = shipments;
        this.modificationDate = new Date();
        this.status = DeliveryStatus.UTWORZONA;
        setShipments(shipments);
    }

    private Date modificationDate;

    private Date registrationDate;

    private Date delivaryDate;

    private DeliveryStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id", updatable = false, insertable = false, nullable = false)
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "employee_id", updatable = false, insertable = false, nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "delivery")
    private List<Shipment> shipments;

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getDelivaryDate() {
        return delivaryDate;
    }

    public void setDelivaryDate(Date delivaryDate) {
        this.delivaryDate = delivaryDate;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public void setStatus(DeliveryStatus status) {
        this.status = status;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }
}
