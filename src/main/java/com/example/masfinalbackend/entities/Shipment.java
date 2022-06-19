package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.ShipmentState;

import javax.persistence.*;
import java.util.Date;

@Entity(name="shipment")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Shipment {

    public Shipment() {}

    public Shipment(String sender, String recipient) {
        this.sender = sender;
        this.recipient = recipient;
        this.shipmentState = ShipmentState.OCZEKUJACA_NA_WYDANIE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shipment_id;

    public long getShipment_id() {
        return shipment_id;
    }

    private void setShipment_id(long id) {
        this.shipment_id = id;
    }

    private String sender;
    private String recipient;

    private ShipmentState shipmentState;

    private Date acceptingDate;
    private Date deliveryDate;

    @ManyToOne
    @JoinColumn(name="address_id", updatable = false, insertable = false, nullable = false)
    private Address senderAddress;

    @ManyToOne
    @JoinColumn(name="address_id", updatable = false, insertable = false, nullable = false)
    private Address recipientAddress;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private PostOfficeEmployee acceptingEmployee;

    @Transient
    public abstract double getShipmentPrice();

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public ShipmentState getShipmentState() {
        return shipmentState;
    }

    public void setShipmentState(ShipmentState shipmentState) {
        this.shipmentState = shipmentState;
    }

    public Date getAcceptingDate() {
        return acceptingDate;
    }

    public void setAcceptingDate(Date acceptingDate) {
        this.acceptingDate = acceptingDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Address getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(Address senderAdress) {
        this.senderAddress = senderAdress;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(Address recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public PostOfficeEmployee getAcceptingEmployee() {
        return acceptingEmployee;
    }

    public void setAcceptingEmployee(PostOfficeEmployee acceptingEmployee) {
        this.acceptingEmployee = acceptingEmployee;
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "nadawca=" + getSender() +
                ", odbiorca=" + getRecipient() +
                ", cena=" + getShipmentPrice() +
                '}';
    }
}