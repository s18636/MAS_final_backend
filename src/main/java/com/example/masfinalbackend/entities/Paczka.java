package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.entities.Przesylka;
import com.example.masfinalbackend.enums.Size;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.example.masfinalbackend.enums.Size.*;

@Entity(name = "paczka")
public class Paczka extends Przesylka {

    private static final double MAX_WAGA = 50;

    private double waga;
    private Size gabaryt;

    public Paczka() {
    }

    public Paczka(String nadawca, String odbiorca, double waga, Size gabaryt) {
        super(nadawca, odbiorca);
        this.waga = waga;
        this.gabaryt = gabaryt;
    }

    @Override
    @Transient
    public double getCena() {
        double cenaCal = 0;
        if (waga < 1)
            cenaCal = 13;
        else if (waga >= 1 && waga < 2)
            cenaCal = 15;
        else if (waga >= 2 && waga < 5)
            cenaCal = 18;
        else if (waga >= 5 && waga < 10)
            cenaCal = 24;

        switch (gabaryt) {
            case S:
                cenaCal += 0;
                break;
            case M:
                cenaCal += 1;
                break;
            case L:
                cenaCal += 2;
                break;
        }

        return cenaCal;
    }

    @Basic
    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    @Basic
    public Size getGabaryt() {
        return gabaryt;
    }

    public void setGabaryt(Size gabaryt) {
        this.gabaryt = gabaryt;
    }

    @Override
    public String toString() {
        return "Paczka{" +
                "waga=" + waga +
                ", gabaryt=" + gabaryt +
                ", nadawca='" + getNadawca() + '\'' +
                ", odbiorca='" + getOdbiorca() + '\'' +
                ", cena=" + getCena() +
                '}';
    }
}