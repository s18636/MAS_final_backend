package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.Size;

import javax.persistence.*;

@Entity(name = "package")
public class Package extends Shipment {

    private static final double MAX_WEIGHT = 50;

    private double weight; //w kg
    private Size size;

    public Package() {}

    public Package(String sender, String recipient, double weight, Size size) {
        super(sender, recipient);
        this.weight = weight;
        this.size = size;
    }

    @Override
    @Transient
    public double getShipmentPrice() {
        double price = 0;
        if (weight < 1)
            price = 13;
        else if (weight >= 1 && weight < 2)
            price = 15;
        else if (weight >= 2 && weight < 5)
            price = 18;
        else if (weight >= 5 && weight < 10)
            price = 24;

        switch (size) {
            case S:
                price += 0;
                break;
            case M:
                price += 1;
                break;
            case L:
                price += 2;
                break;
        }

        return price;
    }

    @Basic
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Basic
    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "waga=" + weight +
                ", gabaryt=" + size +
                ", nadawca='" + getSender() + '\'' +
                ", odbiorca='" + getRecipient() + '\'' +
                ", cena=" + getShipmentPrice() +
                '}';
    }
}