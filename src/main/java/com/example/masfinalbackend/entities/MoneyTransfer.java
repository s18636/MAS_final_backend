package com.example.masfinalbackend.entities;

import javax.persistence.*;

@Entity(name = "moneyTransfer")
public class MoneyTransfer extends Shipment {

    public MoneyTransfer() {}

    public MoneyTransfer(String sender, String recipient, double amount) {
        super(sender, recipient);
        this.amount = amount;
    }

    private double amount;

    @Override
    @Transient
    public double getShipmentPrice() {
        return amount * 0.015;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double value) {
        this.amount = value;
    }

    @Override
    public String toString() {
        return "PrzekazPieniezny{" +
                "wartosc=" + amount +
                ", nadawca='" + getSender() + '\'' +
                ", odbiorca='" + getRecipient() + '\'' +
                ", cena=" + getShipmentPrice() +
                '}';
    }
}
