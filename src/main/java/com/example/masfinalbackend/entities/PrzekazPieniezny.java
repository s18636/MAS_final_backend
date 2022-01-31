package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.entities.Przesylka;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "PrzekazPieniezny")
public class PrzekazPieniezny extends Przesylka {

    private long id;
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private double wartosc;


    public PrzekazPieniezny() {
    }

    public PrzekazPieniezny(String nadawca, String odbiorca, boolean priorytetowa, double wartosc) {
        super(nadawca, odbiorca, priorytetowa);
        this.wartosc = wartosc;
    }

    @Override
    @Transient
    public double getCena() {

        double cenaCal = wartosc * 0.015;

        if (priorytetowa)
            cenaCal += 3;

        return cenaCal;
    }

    @Basic
    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public String toString() {
        return "PrzekazPieniezny{" +
                "wartosc=" + wartosc +
                ", nadawca='" + getNadawca() + '\'' +
                ", odbiorca='" + getOdbiorca() + '\'' +
                ", cena=" + getCena() +
                ", priorytetowa=" + priorytetowa +
                '}';
    }
}
