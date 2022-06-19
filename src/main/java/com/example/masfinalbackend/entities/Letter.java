package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.enums.Size;

import javax.persistence.*;


@Entity(name = "letter")
public class Letter extends Shipment {

    private static final double MAX_WEIGHT = 50;

    private double weight;
    private Size size;

    public Letter() {
    }

    public Letter(String sender, String recipient, double weight, Size size) {
        super(sender, recipient);
        this.weight = weight;
        this.size = size;
    }


    @Transient
    public double getShipmentPrice() {
        double price = 0;

        if(weight < 500) {
            if (size == Size.S)
                price = 5;
            if (size == Size.M)
                price = 7;
            if (size == Size.L)
                price = 15;

        }else if (weight >= 500 && weight < 1000) {
            if (size == Size.M)
                price = 7;
            if (size == Size.L)
                price = 15;
        }
        else if (weight >= 1000 && weight < 2000)
            price = 15;

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
        return "List{" +
                "waga=" + weight +
                ", format=" + size +
                ", nadawca='" + getSender() + '\'' +
                ", odbiorca='" + getRecipient() + '\'' +
                ", cena=" + getShipmentPrice() +
                '}';
    }
}

