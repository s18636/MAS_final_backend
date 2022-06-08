package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.entities.Przesylka;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "przekazPieniezny")
public class PrzekazPieniezny extends Przesylka {

    private double wartosc;


    public PrzekazPieniezny() {
    }

    public PrzekazPieniezny(String nadawca, String odbiorca, double wartosc) {
        super(nadawca, odbiorca);
        this.wartosc = wartosc;
    }

    @Override
    @Transient
    public double getCena() {

        double cenaCal = wartosc * 0.015;

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
                '}';
    }
}
