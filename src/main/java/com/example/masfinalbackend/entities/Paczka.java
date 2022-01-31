package com.example.masfinalbackend.entities;

import com.example.masfinalbackend.entities.Przesylka;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Paczka")
public class Paczka extends Przesylka {

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

    private double waga;
    private char gabaryt;

    public Paczka() {
    }

    public Paczka(String nadawca, String odbiorca, boolean priorytetowa, double waga, char gabaryt) {
        super(nadawca, odbiorca, priorytetowa);
        this.waga = waga;
        this.gabaryt = gabaryt;
    }

    @Override
    @Transient
    public double getCena() {
        double cenaCal = 0;
        if(waga < 1 )
            cenaCal = 13;
        else if (waga >= 1 && waga < 2)
            cenaCal = 15;
        else if (waga >= 2 && waga < 5)
            cenaCal = 18;
        else if(waga >=5 && waga < 10)
            cenaCal = 24;

        if(priorytetowa)
            cenaCal += 1;

        switch (gabaryt) {
            case 'A':
            case 'a': cenaCal += 0;
                break;
            case 'B':
            case 'b' : cenaCal += 1;
                break;
            default : cenaCal += 2;
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
    public char getGabaryt() {
        return gabaryt;
    }

    public void setGabaryt(char gabaryt) {
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
                ", priorytetowa=" + priorytetowa +
                '}';
    }
}